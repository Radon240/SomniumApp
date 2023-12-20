package com.example.somniumapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.Toolbar
import androidx.preference.PreferenceManager
import com.example.somniumapp.features.article.ArticleRepository
import kotlinx.coroutines.runBlocking
import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser
import org.koin.android.ext.android.inject

class ArticleRenderer() : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var webView: WebView
    private val articleRepository: ArticleRepository by inject()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        setTheme(ThemeHelper.setThemeOfApp(sharedPreferences))

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_renderer)

        val articleRendererToolbar: Toolbar = findViewById(R.id.articleRendererToolbar)
        setSupportActionBar(articleRendererToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val articleTitle = intent.getStringExtra("articleTitle")
        val articleId = intent.getStringExtra("articleId")
        val articleCategoryName = intent.getStringExtra("articleCategoryName")
        val articleCategoryId = intent.getStringExtra("articleCategoryId")

        supportActionBar?.title = articleTitle

            onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                intent = Intent(this@ArticleRenderer, MainActivity::class.java)
                intent.putExtra("category", articleCategoryName)
                intent.putExtra("category", articleCategoryId)

                startActivity(intent)
                finish()
            }
        })

        articleRendererToolbar.setNavigationOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }

        webView = findViewById(R.id.articleRendererWebView)
        webView.settings.builtInZoomControls = true
        webView.settings.displayZoomControls = true

        val article = runBlocking {
            articleRepository.getArticle(articleId.toString())
        }

        val src = article.content

        val flavour = CommonMarkFlavourDescriptor()
        val parsedTree = MarkdownParser(flavour).buildMarkdownTreeFromString(src)
        val html = HtmlGenerator(src, parsedTree, flavour).generateHtml()

        webView.loadData(html, "text/html", "UTF-8")
    }
}
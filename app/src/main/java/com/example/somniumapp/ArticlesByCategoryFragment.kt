import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.somniumapp.ArticleRenderer
import com.example.somniumapp.R
import com.example.somniumapp.features.article.ArticleAdapter
import com.example.somniumapp.features.article.ArticleRepository
import com.example.somniumapp.features.article.model.GetArticleResponse
import com.example.somniumapp.features.article.model.GetArticlesByCategoryResponse
import com.example.somniumapp.features.category.model.GetCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject
import org.koin.core.definition.indexKey

class ArticlesByCategoryFragment(private val category: String) : Fragment() , ArticleAdapter.ClickListener{

    private lateinit var recyclerView: RecyclerView
    private lateinit var customAdapter: ArticleAdapter
    private val articleRepository: ArticleRepository by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_articles_by_category, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

        val articles = runBlocking {
            articleRepository.getArticles(category)
        }
        customAdapter = ArticleAdapter(this, articles)
        recyclerView.adapter = customAdapter

        recyclerView.setOnClickListener{
            onClick(articles, it.verticalScrollbarPosition)
        }
    }
    override fun onClick(articles: GetArticlesByCategoryResponse, position: Int) {
        val intent = Intent(requireContext(), ArticleRenderer::class.java)
        intent.putExtra("articleId", articles.data[position].id)
        intent.putExtra("articleTitle", articles.data[position].title)
        intent.putExtra("articleCategoryId", category)
        startActivity(intent)
    }
}

package com.example.somniumapp.features.article

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.somniumapp.R
import com.example.somniumapp.databinding.ArticleItemBinding
import com.example.somniumapp.features.article.model.GetArticleResponse
import com.example.somniumapp.features.article.model.GetArticlesByCategoryResponse

class ArticleAdapter(private val articles: List<GetArticlesByCategoryResponse>) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ArticleItemBinding.bind(itemView)
        fun bind(article: GetArticlesByCategoryResponse) = with(binding){
            articleTitle.text = article.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount(): Int {
        return articles.size
    }
}

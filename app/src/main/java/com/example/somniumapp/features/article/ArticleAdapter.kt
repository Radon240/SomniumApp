package com.example.somniumapp.features.article

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.somniumapp.ArticleRenderer
import com.example.somniumapp.R
import com.example.somniumapp.databinding.ArticleItemBinding
import com.example.somniumapp.features.article.model.GetArticleResponse
import com.example.somniumapp.features.article.model.GetArticlesByCategoryResponse

class ArticleAdapter(private val listener: ClickListener, private val articles: GetArticlesByCategoryResponse) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    interface ClickListener{
        fun onClick(articles: GetArticlesByCategoryResponse, position: Int)
    }

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ArticleItemBinding.bind(itemView)
        fun bind( listener: ClickListener, articles: GetArticlesByCategoryResponse, position: Int) = with(binding){
            articleTitle.text = articles.data[position].title

            itemView.setOnClickListener{
                listener.onClick(articles, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(listener, articles, position)
    }

    override fun getItemCount(): Int {
        return articles.data.size
    }
}

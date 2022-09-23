package com.example.sennatask.ui.article

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sennatask.data.model.Article
import com.example.sennatask.databinding.ArticleItemBinding
import com.example.sennatask.ui.details.DetailsActivity

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    private var articles: List<Article> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(articles: List<Article>) {
        this.articles = articles
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ArticleItemBinding.inflate(inflater, parent, false)

        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article: Article = articles[position]
        holder.bind(article)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            intent.putExtra("article",article)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }


    inner class ArticleViewHolder(private val binding: ArticleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.article = article
        }

    }


}
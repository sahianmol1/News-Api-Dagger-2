package com.example.newsappdagger.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsappdagger.R
import com.example.newsappdagger.databinding.ItemNewsArticleBinding
import com.example.newsappdagger.di.ImageLoader
import com.example.newsappdagger.models.Article
import javax.inject.Inject

class NewsAdapter(private val articles: List<Article>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(itemView = binding.root)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = articles[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = articles.size


    inner class NewsViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        val image = itemView.findViewById<ImageView>(R.id.img_article)
        val title = itemView.findViewById<TextView>(R.id.tv_title)

        fun bind(item: Article) {
            title.text = item.title
            Glide.with(itemView).load(item.urlToImage).into(image)
        }
    }
}
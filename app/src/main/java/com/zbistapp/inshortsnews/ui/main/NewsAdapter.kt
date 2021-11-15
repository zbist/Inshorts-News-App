package com.zbistapp.inshortsnews.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.zbistapp.inshortsnews.R
import com.zbistapp.inshortsnews.domain.NewsEntity

class NewsAdapter(
    private val onClick: (NewsEntity) -> Unit
) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    var listOfNews = emptyList<NewsEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item, parent, false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        with(holder) {
            titleTv.text = listOfNews[position].title
            dateTv.text = listOfNews[position].time
        }
    }

    override fun getItemCount(): Int = listOfNews.size

    inner class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTv: MaterialTextView = itemView.findViewById(R.id.news_item_title_text_view)
        val dateTv: MaterialTextView = itemView.findViewById(R.id.news_item_date_text_view)

        init {
            itemView.setOnClickListener {
                onClick(listOfNews[layoutPosition])
            }
        }
    }
}
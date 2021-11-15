package com.zbistapp.inshortsnews.ui.newsDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.zbistapp.inshortsnews.R
import com.zbistapp.inshortsnews.databinding.FragmentNewsDetailsBinding
import com.zbistapp.inshortsnews.domain.NewsEntity

class NewsDetailsFragment : Fragment(R.layout.fragment_news_details) {

    private val binding: FragmentNewsDetailsBinding
            by viewBinding(FragmentNewsDetailsBinding::bind)

    private lateinit var news: NewsEntity

    companion object {

        private const val NEWS_DETAIL_PARAM_KEY = "NEWS_DETAIL_PARAM_KEY"

        fun newInstance(news: NewsEntity) =
            NewsDetailsFragment().apply {
                arguments = Bundle().apply { putParcelable(NEWS_DETAIL_PARAM_KEY, news) }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        news = arguments?.getParcelable(NEWS_DETAIL_PARAM_KEY)
            ?: NewsEntity("0", "", "", "false", "", "", "")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initNewsDetails()
    }

    private fun initNewsDetails() {
        with(binding) {
            Glide.with(posterImageView)
                .load(news.imageUrl)
                .into(posterImageView)

            titleTextView.text = news.title
            authorTextView.text = news.author
            dateTextView.text = news.date
            contentTextView.text = news.content
            readMoreTextView.text = news.readMoreUrl
        }
    }
}
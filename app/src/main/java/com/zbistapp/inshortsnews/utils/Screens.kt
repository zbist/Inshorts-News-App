package com.zbistapp.inshortsnews.utils

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.zbistapp.inshortsnews.domain.NewsEntity
import com.zbistapp.inshortsnews.ui.newsDetails.NewsDetailsFragment

object Screens {
    fun newsDetailsScreen(news: NewsEntity) =
        FragmentScreen { NewsDetailsFragment.newInstance(news) }
}
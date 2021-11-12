package com.zbistapp.inshortsnews.ui.main

import com.zbistapp.inshortsnews.domain.NewsEntity
import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

class MainContract {

    interface View : MvpView {
        @AddToEndSingle
        fun setNews(listOfNews: List<NewsEntity>)

        @Skip
        fun setError(errorText: String?)
    }

    abstract class Presenter : MvpPresenter<View>() {
        abstract fun onNewsItemClicked(news: NewsEntity)
        abstract fun onUpdate()
    }
}
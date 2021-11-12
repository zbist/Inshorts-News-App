package com.zbistapp.inshortsnews.data

import com.zbistapp.inshortsnews.domain.INewsRepo
import com.zbistapp.inshortsnews.domain.NewsEntity
import com.zbistapp.inshortsnews.domain.network.NewsApi
import io.reactivex.Single

class NewsRepoImpl(
    private val newsApi: NewsApi
) : INewsRepo {

    override fun getAllNews(): Single<List<NewsEntity>> =
        newsApi.getNews()
            .map { it.data }

}
package com.zbistapp.inshortsnews.domain.network

import com.zbistapp.inshortsnews.domain.NewsEntity
import com.zbistapp.inshortsnews.domain.RetrofitDataResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("/news")
    fun getNews(
        @Query("category") category: String = "all"
    ): Single<RetrofitDataResponse>
}
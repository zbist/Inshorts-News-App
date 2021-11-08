package com.zbistapp.inshortsnews.domain

import io.reactivex.Single

interface INewsRepo {

    fun getAllNews(): Single<List<NewsEntity>>
}
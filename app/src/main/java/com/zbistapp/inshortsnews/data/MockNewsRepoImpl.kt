package com.zbistapp.inshortsnews.data

import com.zbistapp.inshortsnews.domain.INewsRepo
import com.zbistapp.inshortsnews.domain.NewsEntity
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class MockNewsRepoImpl : INewsRepo {

    override fun getAllNews(): Single<List<NewsEntity>> {

       return Single.just(
            listOf(
                NewsEntity(
                    "qgegwgwgeww",
                    "geweegggl",
                    "bpnnqqp",
                    "124wghso",
                    "oqhgqendov",
                    "12 23 4444",
                    "some titile text",
                ),
                NewsEntity(
                    "qgegwgwgeww",
                    "geweegggl",
                    "bpnnqqp",
                    "124wghso",
                    "oqhgqendov",
                    "12 23 4444",
                    "some titile text",
                ),
                NewsEntity(
                    "qgegwgwgeww",
                    "geweegggl",
                    "bpnnqqp",
                    "124wghso",
                    "oqhgqendov",
                    "12 23 4444",
                    "some titile text",
                ),
                NewsEntity(
                    "qgegwgwgeww",
                    "geweegggl",
                    "bpnnqqp",
                    "124wghso",
                    "oqhgqendov",
                    "12 23 4444",
                    "some titile text",
                ),
                NewsEntity(
                    "qgegwgwgeww",
                    "geweegggl",
                    "bpnnqqp",
                    "124wghso",
                    "oqhgqendov",
                    "12 23 4444",
                    "some titile text",
                ),
                NewsEntity(
                    "qgegwgwgeww",
                    "geweegggl",
                    "bpnnqqp",
                    "124wghso",
                    "oqhgqendov",
                    "12 23 4444",
                    "some titile text",
                ),
                NewsEntity(
                    "qgegwgwgeww",
                    "geweegggl",
                    "bpnnqqp",
                    "124wghso",
                    "oqhgqendov",
                    "12 23 4444",
                    "some titile text",
                ),
                NewsEntity(
                    "qgegwgwgeww",
                    "geweegggl",
                    "bpnnqqp",
                    "124wghso",
                    "oqhgqendov",
                    "12 23 4444",
                    "some titile text",
                ),
                NewsEntity(
                    "qgegwgwgeww",
                    "geweegggl",
                    "bpnnqqp",
                    "124wghso",
                    "oqhgqendov",
                    "12 23 4444",
                    "some titile text",
                ),
                NewsEntity(
                    "qgegwgwgeww",
                    "geweegggl",
                    "bpnnqqp",
                    "124wghso",
                    "oqhgqendov",
                    "12 23 4444",
                    "some titile text",
                ),
                NewsEntity(
                    "qgegwgwgeww",
                    "geweegggl",
                    "bpnnqqp",
                    "124wghso",
                    "oqhgqendov",
                    "12 23 4444",
                    "some titile text",
                ),
                NewsEntity(
                    "qgegwgwgeww",
                    "geweegggl",
                    "bpnnqqp",
                    "124wghso",
                    "oqhgqendov",
                    "12 23 4444",
                    "some titile text",
                ),
            )
        )
    }
}
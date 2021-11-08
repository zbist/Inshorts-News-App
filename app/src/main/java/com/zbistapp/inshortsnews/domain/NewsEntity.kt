package com.zbistapp.inshortsnews.domain

data class NewsEntity(
    val author: String,
    val content: String,
    val date: String,
    val imageUrl: String,
    val readMoreUrl: String,
    val time: String,
    val title: String,
)
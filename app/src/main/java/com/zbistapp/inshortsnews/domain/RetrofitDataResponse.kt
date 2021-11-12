package com.zbistapp.inshortsnews.domain

import com.google.gson.annotations.SerializedName

data class RetrofitDataResponse(
    @SerializedName("data") val data: List<NewsEntity>
)

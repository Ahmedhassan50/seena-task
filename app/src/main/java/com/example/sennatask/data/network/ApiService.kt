package com.example.sennatask.data.network

import com.example.sennatask.data.network.response.ArticleResponse
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {


    @GET("facebook.json")
    fun getArticles(@Query("api-key")key:String):Single<ArticleResponse>

}
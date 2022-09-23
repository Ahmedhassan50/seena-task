package com.example.sennatask.data.repository

import com.example.sennatask.BuildConfig
import com.example.sennatask.data.network.ApiService
import com.example.sennatask.data.network.response.ArticleResponse
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ArticleRepository @Inject constructor(private val apiService: ApiService) {

    fun gerArticles():Single<ArticleResponse>{
       return apiService.getArticles(BuildConfig.API_KEY)
    }

}
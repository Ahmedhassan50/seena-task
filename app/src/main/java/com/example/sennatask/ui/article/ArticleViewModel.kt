package com.example.sennatask.ui.article

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sennatask.data.model.Article
import com.example.sennatask.data.network.response.ArticleResponse
import com.example.sennatask.data.repository.ArticleRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject



class ArticleViewModel
@Inject
constructor (private val articleRepository: ArticleRepository):ViewModel() {

    private val _articles = MutableLiveData<List<Article>>()
    val articles :LiveData<List<Article>>
    get() =_articles


    fun getArticles(){
      articleRepository.gerArticles()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
       .subscribe(object :SingleObserver<ArticleResponse>{
           override fun onSubscribe(d: Disposable) {

           }

           override fun onSuccess(article: ArticleResponse) {


               val articles:List<Article> = article.results.map{result->
                   val article = Article(
                       title = result.title,
                       publishedBy = result.publishedBy,
                       publishedDate = result.publishedDate,
                       summary = result.summary,
                       image = result.media[0].mediaMetadata[2].url
                   )
                   article
               }

              _articles.value = articles

           }

           override fun onError(e: Throwable) {
               Log.e("TAG",e.message?:"")
           }
       })




    }

}
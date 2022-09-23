package com.example.sennatask.di.article

import androidx.lifecycle.ViewModel
import com.example.sennatask.di.ViewModelKey
import com.example.sennatask.ui.article.ArticleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ArticleViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ArticleViewModel::class)
    abstract fun bindArticleViewModel(articleViewModel: ArticleViewModel):ViewModel


}
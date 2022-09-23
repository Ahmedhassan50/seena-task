package com.example.sennatask.di

import com.example.sennatask.di.article.ArticleViewModelModule
import com.example.sennatask.ui.article.ArticleActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [ArticleViewModelModule::class])
    abstract fun contributeNewsActivity(): ArticleActivity

}

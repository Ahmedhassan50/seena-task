package com.example.sennatask.di

import androidx.lifecycle.ViewModelProvider
import com.example.sennatask.ViewModelFactory
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}
package com.example.sennatask.di


import com.example.sennatask.data.network.ApiService
import com.example.sennatask.uitl.Constants
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton



@Module
class AppModule {


 @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return  Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    @Provides
    fun provideApiServiceInstance(retrofit: Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)
    }

}

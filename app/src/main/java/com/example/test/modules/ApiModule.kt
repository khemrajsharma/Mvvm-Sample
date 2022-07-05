package com.example.test.modules

import com.example.newsample.repository.KanyeWestApi
import com.example.test.repository.MainRepositoryImpl
import com.example.test.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://api.kanye.rest/"

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideKanyeWestApi():KanyeWestApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(KanyeWestApi::class.java)

    @Singleton
    @Provides
    fun provideRepository(kanyewestapi:KanyeWestApi) : MainRepository = MainRepositoryImpl(kanyewestapi)


}
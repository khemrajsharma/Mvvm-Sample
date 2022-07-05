package com.example.newsample.repository

import com.example.newsample.model.KanyeWestApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface KanyeWestApi {

    @GET(".")
    suspend fun getQuotes(): Response<KanyeWestApiResponse>


}
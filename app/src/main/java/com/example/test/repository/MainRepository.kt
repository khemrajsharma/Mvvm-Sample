package com.example.test.repository

import com.example.newsample.model.KanyeWestApiResponse
import com.example.newsample.model.Resource

interface MainRepository {
    suspend fun getQuotes(): Resource<KanyeWestApiResponse>
}
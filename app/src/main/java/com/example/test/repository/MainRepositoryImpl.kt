package com.example.test.repository

import com.example.newsample.model.KanyeWestApiResponse
import com.example.newsample.model.Resource
import com.example.newsample.repository.KanyeWestApi
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    val kanyeWestApi: KanyeWestApi
):MainRepository {
    override suspend fun getQuotes(): Resource<KanyeWestApiResponse> {
        return try {
            val response = kanyeWestApi.getQuotes()
            val result = response.body()
            if (response.isSuccessful && result != null){
                Resource.Success(result)
            }else{
                Resource.Error("An Error occurred")
            }
        }catch (e:Exception){
            println("kanyeWestApi $e")
            Resource.Error("An $e occurred")
        }
    }
}
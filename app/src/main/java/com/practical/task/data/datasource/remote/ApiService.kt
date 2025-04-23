package com.practical.task.data.datasource.remote



import com.practical.task.data.model.DiscoveryResponse
import retrofit2.http.GET


interface ApiService {

    @GET("testdiscovery")
    suspend fun getDiscoveryData(): DiscoveryResponse
}
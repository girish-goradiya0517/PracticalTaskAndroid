package com.practical.task.data.repository.remote

import com.practical.task.data.datasource.remote.ApiService
import com.practical.task.data.model.DiscoveryResponse
import com.practical.task.utils.network.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import javax.inject.Inject

class DiscoveryRepository @Inject constructor(
    private val apiService: ApiService,
) : DiscoveryInterface {

    override suspend fun getDiscoveryData() : Flow<DataState<DiscoveryResponse>> = flow {
        emit(DataState.Loading)
        try {
            val searchResult = apiService.getDiscoveryData()
            emit(DataState.Success(searchResult))

        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}
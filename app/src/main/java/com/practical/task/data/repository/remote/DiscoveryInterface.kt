package com.practical.task.data.repository.remote

import com.practical.task.data.model.DiscoveryResponse
import com.practical.task.utils.network.DataState
import kotlinx.coroutines.flow.Flow

interface DiscoveryInterface {
    suspend fun getDiscoveryData(): Flow<DataState<DiscoveryResponse>>
}
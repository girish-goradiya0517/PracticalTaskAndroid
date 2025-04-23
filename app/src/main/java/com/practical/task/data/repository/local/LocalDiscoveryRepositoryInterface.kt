package com.practical.task.data.repository.local


import com.practical.task.data.model.DiscoveryResponse


interface LocalDiscoveryRepositoryInterface {
    fun getDiscoveryData(): DiscoveryResponse?
    fun saveDiscoveryData(discoveryEntity: DiscoveryResponse)
    fun clearDiscoveryData()
}
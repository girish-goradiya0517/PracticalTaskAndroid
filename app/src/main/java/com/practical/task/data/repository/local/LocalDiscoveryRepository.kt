package com.practical.task.data.repository.local


import android.content.Context
import com.google.gson.Gson

import com.practical.task.data.model.DiscoveryResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class LocalDiscoveryRepository @Inject constructor(
   @ApplicationContext context: Context,
) : LocalDiscoveryRepositoryInterface {

    private val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    private val gson = Gson()

    companion object {
        private const val PREF_NAME = "DiscoveryPreferences"
        private const val DISCOVERY_KEY = "discovery_data"
        private const val LAST_REFRESH_TIME_KEY = "last_refresh_time"
        private const val REFRESH_INTERVAL_MILLIS = 2 * 60 * 60 * 1000
    }

    override fun getDiscoveryData(): DiscoveryResponse? {
        val jsonData = sharedPreferences.getString(DISCOVERY_KEY, null)
        return if (jsonData != null) {
            gson.fromJson(jsonData, DiscoveryResponse::class.java)
        } else {
            null
        }
    }

    override fun saveDiscoveryData(discoveryEntity: DiscoveryResponse) {
        val jsonData = gson.toJson(discoveryEntity)
        val currentTime = System.currentTimeMillis()

        sharedPreferences.edit()
            .putString(DISCOVERY_KEY, jsonData)
            .putLong(LAST_REFRESH_TIME_KEY, currentTime)
            .apply()
    }

    override fun clearDiscoveryData() {
        sharedPreferences.edit()
            .remove(DISCOVERY_KEY)
            .remove(LAST_REFRESH_TIME_KEY)
            .apply()
    }

    /**
     * Checks whether the stored discovery data is older than the refresh interval.
     * @return true if the data needs to be refreshed, false otherwise.
     */

    fun isDataStale(): Boolean {
        val lastRefreshTime = sharedPreferences.getLong(LAST_REFRESH_TIME_KEY, 0L)
        val currentTime = System.currentTimeMillis()
        return (currentTime - lastRefreshTime) > REFRESH_INTERVAL_MILLIS
    }
}

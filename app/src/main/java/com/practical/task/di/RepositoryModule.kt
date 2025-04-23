package com.practical.task.di

import com.practical.task.data.datasource.remote.ApiService

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    /**
     * Provides RemoteDataRepository for access api service method
     */


}
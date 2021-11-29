package com.example.aplicationtestinglayout.di

import com.example.cardview.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton

    fun provideTaskService (): Repository {

        return Repository()

    }

}
package com.example.fetch_take_home_challenge.di

import com.example.fetch_take_home_challenge.data.retrofit.ListRepositoryImpl
import com.example.fetch_take_home_challenge.domain.repository.ListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindListRepository(impl: ListRepositoryImpl): ListRepository
}
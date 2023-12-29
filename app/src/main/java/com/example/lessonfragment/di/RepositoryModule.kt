package com.example.lessonfragment.di

import com.example.lessonfragment.repository.ProductRepoInterface
import com.example.lessonfragment.repository.ProductRepository
import com.example.lessonfragment.repository.UserRepoInterface
import com.example.lessonfragment.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindUserRepository(prm : UserRepository) : UserRepoInterface

    @Binds
    abstract fun bindProductRepository(prm : ProductRepository) : ProductRepoInterface
}
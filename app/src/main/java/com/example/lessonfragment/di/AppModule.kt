package com.example.lessonfragment.di

import android.content.Context
import androidx.room.Room
import com.example.lessonfragment.dao.ProductDao
import com.example.lessonfragment.db.AppDatabase
import com.example.lessonfragment.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun providerProductDao(database: AppDatabase) : ProductDao{
        return database.productDao()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context : Context) : AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "demodb").build()
    }
}
package com.example.lessonfragment

import android.app.Application
import com.example.lessonfragment.db.AppDatabase
import com.example.lessonfragment.repository.ProductRepository
import com.example.lessonfragment.repository.UserRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}
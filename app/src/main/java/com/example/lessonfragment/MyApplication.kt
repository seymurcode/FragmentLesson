package com.example.lessonfragment

import android.app.Application
import com.example.lessonfragment.db.AppDatabase
import com.example.lessonfragment.repository.ProductRepository
import com.example.lessonfragment.repository.UserRepository

class MyApplication : Application() {

    // Inflate the layout for this fragment
    val database by lazy { AppDatabase.getDatabase(this) } //istifade etdilende gelir
    val userRepository by lazy { UserRepository(database.userDao()) }
    val productRepository by lazy { ProductRepository(database.productDao()) }
    override fun onCreate() {
        super.onCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}
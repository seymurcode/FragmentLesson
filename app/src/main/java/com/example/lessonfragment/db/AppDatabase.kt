package com.example.lessonfragment.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lessonfragment.dao.ProductDao
import com.example.lessonfragment.dao.UserDao
import com.example.lessonfragment.model.Product
import com.example.lessonfragment.model.User

@Database(entities = [User::class, Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun productDao(): ProductDao

    companion object {
        private var DATABASE_INSTANCE : AppDatabase? = null
        fun getDatabase(context : Context) : AppDatabase{
            if(DATABASE_INSTANCE!=null) {
                return DATABASE_INSTANCE!!
            }
            else{
                val instance = Room.databaseBuilder(context,AppDatabase::class.java,"demodb").build()
                DATABASE_INSTANCE=instance
                return DATABASE_INSTANCE!!
            }
        }
    }
}
package com.example.lessonfragment.repository

import androidx.lifecycle.LiveData
import com.example.lessonfragment.dao.UserDao
import com.example.lessonfragment.model.User

class UserRepository(private val userDao:UserDao) {
    suspend fun insert(user:User){
        userDao.insert(user)
    }

    fun getAll():LiveData<List<User>>{
        return userDao.getAll()
    }
}
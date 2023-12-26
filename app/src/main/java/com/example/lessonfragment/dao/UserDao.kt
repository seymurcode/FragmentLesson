package com.example.lessonfragment.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.lessonfragment.model.User

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user : User) //suspebancaq backgroundda calisir, basqa threadda cagirmaliyiq

    @Query("SELECT * FROM user")
    fun getAll() : LiveData<List<User>>
    @Query("SELECT * FROM user where first_name LIKE :name")
    fun findWithName(name: String) : LiveData<List<User>>
    @Query("SELECT * FROM user where first_name LIKE :name and last_name LIKE :lastName")
    fun findWithNameLastname(name: String, lastName: String) : LiveData<List<User>>

    //CRUD islemleri
    @Delete
    suspend fun delete (user: User)


}
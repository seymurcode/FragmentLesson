package com.example.lessonfragment.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.lessonfragment.model.Product
import com.example.lessonfragment.model.User

@Dao
interface ProductDao {
    @Insert
    suspend fun insert(product: Product) //suspebancaq backgroundda calisir, basqa threadda cagirmaliyiq

    @Query("SELECT * FROM product")
    fun getAll() : LiveData<List<Product>>
    @Delete
    suspend fun delete (product: Product)

}
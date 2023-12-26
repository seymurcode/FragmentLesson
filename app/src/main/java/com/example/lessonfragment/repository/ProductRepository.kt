package com.example.lessonfragment.repository

import androidx.lifecycle.LiveData
import com.example.lessonfragment.dao.ProductDao
import com.example.lessonfragment.dao.UserDao
import com.example.lessonfragment.model.Product
import com.example.lessonfragment.model.User

class ProductRepository(private val productDao: ProductDao) {
    suspend fun insert(product: Product){
        productDao.insert(product)
    }

    fun getAll():LiveData<List<Product>>{
        return productDao.getAll()
    }
}
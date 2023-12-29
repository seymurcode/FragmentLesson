package com.example.lessonfragment.repository

import androidx.lifecycle.LiveData
import com.example.lessonfragment.dao.ProductDao
import com.example.lessonfragment.dao.UserDao
import com.example.lessonfragment.model.Product
import com.example.lessonfragment.model.User
import javax.inject.Inject

interface ProductRepoInterface{

}
class ProductRepository @Inject constructor(private val productDao: ProductDao) : ProductRepoInterface {
    suspend fun insert(product: Product){
        productDao.insert(product)
    }

    fun getAll():LiveData<List<Product>>{
        return productDao.getAll()
    }
}
package com.example.lessonfragment.features.fragments.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lessonfragment.model.Product
import com.example.lessonfragment.repository.ProductRepository

class ProductsViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var productList = mutableListOf<Product>()
    lateinit var productRepository: ProductRepository

    fun getAllData() : LiveData<List<Product>> {
        return productRepository.getAll()
    }
}
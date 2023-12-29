package com.example.lessonfragment.features.fragments.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lessonfragment.model.Product
import com.example.lessonfragment.repository.ProductRepository
import com.example.lessonfragment.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor (var userRepository: UserRepository,
                                             var productRepository: ProductRepository) : ViewModel() {
    // TODO: Implement the ViewModel
    var productList = mutableListOf<Product>()
    fun getAllData() : LiveData<List<Product>> {
        return productRepository.getAll()
    }
}
package com.example.lessonfragment.features.fragments.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lessonfragment.model.Product
import com.example.lessonfragment.repository.ProductRepository
import kotlinx.coroutines.launch

class AddViewModel: ViewModel() {
    lateinit var productRepository: ProductRepository
    var addProductEvent = MutableLiveData<Boolean>()

    fun onButtonClick() {
        addProductEvent.postValue(true)
    }

    fun insert(product: Product){
        viewModelScope.launch {
            productRepository.insert(product)
        }
    }
    fun getAllData() : LiveData<List<Product>>{
        return productRepository.getAll()
    }
}
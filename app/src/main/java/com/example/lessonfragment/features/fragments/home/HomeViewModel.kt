package com.example.lessonfragment.features.fragments.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lessonfragment.model.Product

class HomeViewModel : ViewModel() {


    var productList = mutableListOf<Product>()
    var buttonClickObserver= MutableLiveData<Boolean>()

    fun buttonClick(){
        buttonClickObserver.postValue(true)
    }

    fun addProduct(product:Product) : Product? {
        if (product.name.isEmpty() || product.code.isEmpty()) {
            return null
        }

        return product;
    }
}
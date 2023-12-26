package com.example.lessonfragment.features.fragments.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lessonfragment.model.Product

class DeatilViewModel : ViewModel() {
    var productList= mutableListOf<Product>()

    var updateListener=MutableLiveData<Boolean>()

    fun appendProductList(item: Product){
        productList.add(item)
        updateListener.postValue(true)
    }

}
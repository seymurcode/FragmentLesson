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

    var nameText = MutableLiveData<String>()
    var codeText = MutableLiveData<String>()
    var descriptionText = MutableLiveData<String>()

    var errorObserver = MutableLiveData<String>()

    fun onButtonClick() {

        if(nameText.value.isNullOrEmpty() || codeText.value.isNullOrEmpty() || descriptionText.value.isNullOrEmpty()){
            errorObserver.postValue("Eksik bilgiler!")
            return
        }
        addProductEvent.postValue(true)
    }

    fun createNewProduct() : Product{
        return Product(0,nameText.value ?: "", codeText.value ?: "", descriptionText.value ?: "")
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
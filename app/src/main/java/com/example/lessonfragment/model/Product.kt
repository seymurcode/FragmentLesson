package com.example.lessonfragment.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(val name : String, val code : String, val description : String) : Parcelable {

}
package com.example.lessonfragment.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Product(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name="product_name") val name: String,
    @ColumnInfo(name="product_code") val code : String,
    @ColumnInfo(name="product_description") val description : String
) : Parcelable {}
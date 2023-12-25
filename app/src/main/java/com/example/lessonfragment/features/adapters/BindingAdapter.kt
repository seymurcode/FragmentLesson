package com.example.lesson2.features.adapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.lang.Exception

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("isVisible")
    fun showHide(view: View, show : Boolean){
        view.visibility = if(show) View.VISIBLE
        else View.GONE
    }

    @JvmStatic
    @BindingAdapter("imageUri")
    fun setImageUrl(imageView: ImageView, url: String?){
        try {
            url.takeIf{!it.isNullOrEmpty()}?.apply {
                Glide.with(imageView.context)
                    .load(url)
                    .into(imageView)
            }?:run{

            }
        }
        catch (e: Exception){

        }
    }
}
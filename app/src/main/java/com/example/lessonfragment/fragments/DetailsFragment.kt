package com.example.fragmentproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lessonfragment.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    lateinit var binding: FragmentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentDetailsBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root    }
}
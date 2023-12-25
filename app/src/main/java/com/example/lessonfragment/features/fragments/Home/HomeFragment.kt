package com.example.lessonfragment.features.fragments.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import com.example.lessonfragment.databinding.FragmentDetailsBinding
import com.example.lessonfragment.databinding.FragmentHomeBinding
import com.example.lessonfragment.features.fragments.Detail.DetailsFragment


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: HomeViewModel

    fun openProductPage() {
        //val action = MenuFragmentDirections.actionMenuToProducts()
        /*setFragmentResultListener(DetailsFragment.resultKey){ requestKey, bundle ->
            print(bundle)
        }*/

        //val action = DetailsFragmentDirections.actionMenuToProductDetail()
        //findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentHomeBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        // Inflate the layout for this fragment
        return binding.root
    }
}
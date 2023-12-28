package com.example.lessonfragment.features.fragments.products

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lesson2.features.adapters.ProductListAdapter
import com.example.lessonfragment.MyApplication
import com.example.lessonfragment.databinding.FragmentAddBinding
import com.example.lessonfragment.databinding.FragmentProductsBinding
import com.example.lessonfragment.features.fragments.add.AddFragmentDirections
import com.example.lessonfragment.features.fragments.add.AddViewModel
import com.example.lessonfragment.features.fragments.detail.DetailsFragment
import com.example.lessonfragment.features.fragments.detail.DetailsFragment.Companion.resultKey
import com.example.lessonfragment.model.Product
import com.example.lessonfragment.repository.ProductRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ProductsFragment : Fragment() {


    lateinit var viewModel: ProductsViewModel
    lateinit var binding: FragmentProductsBinding
    var adapter : ProductListAdapter?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel=ViewModelProvider(this).get(ProductsViewModel::class.java)
        viewModel.productRepository=(activity?.application as MyApplication).productRepository
        binding= FragmentProductsBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        context?.let {

            runBlocking {
                launch {
                    viewModel.productRepository.getAll().observe(this@ProductsFragment.viewLifecycleOwner) { productList->

                        adapter=  ProductListAdapter(it, productList.toMutableList(), onClick = {
                            openDetailPage(it)
                        })
                        binding.listView.adapter=adapter
                    }
                }
                launch {

                }
            }
        }



        return binding.root
    }

    fun openDetailPage(product : Product) {

        setFragmentResultListener(DetailsFragment.resultKey) { requestKey, bundle ->
            print(bundle)
        }
        val action = ProductsFragmentDirections.actionProductToDetail(product)
        findNavController().navigate(action)
    }
}
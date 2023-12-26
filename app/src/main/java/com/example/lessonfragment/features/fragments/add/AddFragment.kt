package com.example.lessonfragment.features.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import com.example.lessonfragment.MyApplication
import com.example.lessonfragment.databinding.FragmentAddBinding
import com.example.lessonfragment.features.fragments.detail.DetailsFragment
import com.example.lessonfragment.model.Product
import androidx.navigation.fragment.findNavController


/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment() {

    lateinit var binding: FragmentAddBinding
    lateinit var viewModel: AddViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel=ViewModelProvider(this).get(AddViewModel::class.java)
        viewModel.productRepository=(activity?.application as MyApplication).productRepository
        binding=FragmentAddBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        viewModel.addProductEvent.observe(this) {
            if(it) {
                openProductPage()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.addProductEvent.removeObservers(this)
        viewModel.addProductEvent.postValue(false)
    }
    fun openProductPage() {
        //val action = MenuFragmentDirections.actionMenuToProducts()
        setFragmentResultListener(DetailsFragment.resultKey){ requestKey, bundle ->
            print(bundle)
        }
        val product = Product(1,"ass","dsad","dsfds")
        val action = AddFragmentDirections.actionAddToList(product)
        findNavController().navigate(action)

    }


}
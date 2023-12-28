package com.example.lessonfragment.features.fragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lessonfragment.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    lateinit var binding: FragmentDetailsBinding
    lateinit var viewModel : DeatilViewModel
    val args : DetailsFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(DeatilViewModel::class.java)
        binding=FragmentDetailsBinding.inflate(inflater)
        binding.btn.setOnClickListener {
            //val bundle = bundleOf("prm1" to 10, "prm2" to "Sefa", "prm3" to 10.2)
            //setFragmentResult(resultKey, bundle)
            findNavController().popBackStack()
        }
        // Inflate the layout for this fragment
        binding.txtProductName.text = args.product.name
        binding.txtProductCode.text = args.product.code
        binding.txtProductDescription.text = args.product.description

        return binding.root
    }

    companion object {
        val resultKey = "RESULT"
    }
}
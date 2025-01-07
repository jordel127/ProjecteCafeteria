package com.jordel.projectecafeteria.Home.Pagament

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.jordel.projectecafeteria.Home.SharedViewModel
import com.jordel.projectecafeteria.R
import com.jordel.projectecafeteria.databinding.FragmentLivePagamentBinding

class FragmentLivePagament : Fragment() {
    val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLivePagamentBinding.inflate(inflater)

        sharedViewModel.selectedItems.observe(viewLifecycleOwner) {
            val totalAmount = sharedViewModel.totalAmount.value ?: 0.0
            if (totalAmount == 0.0) {
                binding.textViewPeruTotalActual.text = "0€"
            } else {
                // Si hay productos seleccionados con cantidad > 0, mostrar el total
                binding.textViewPeruTotalActual.text = "$totalAmount€"
            }
        }

        return binding.root
    }

}
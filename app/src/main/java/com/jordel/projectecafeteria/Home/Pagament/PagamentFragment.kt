package com.jordel.projectecafeteria.Home.Pagament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.jordel.projectecafeteria.Home.SharedViewModel
import com.jordel.projectecafeteria.databinding.FragmentPagamentBinding

class PagamentFragment : Fragment() {
    val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentPagamentBinding.inflate(inflater)

        sharedViewModel.selectedItems.observe(viewLifecycleOwner) {
            val text = it.filter { product -> product.cantitat > 0 }
                .joinToString(separator = "\n") { product ->
                    val sumaCantidadPrecio = (product.preu.toDouble() * product.cantitat).toString()
                    "${product.nom} - ${product.preu}€ - Cantidad: ${product.cantitat} - Total: $sumaCantidadPrecio€"
                }
            if (text.isEmpty()) {
                binding.ListaProductes.text = "No hay productos seleccionados."
            } else {
                binding.ListaProductes.text = text
            }
            val totalAmount = sharedViewModel.totalAmount.value ?: 0.0
            if (totalAmount == 0.0) {
                binding.textViewTotal.text = "0€"
            } else {
                // Si hay productos seleccionados con cantidad > 0, mostrar el total
                binding.textViewTotal.text = "$totalAmount€"
            }
        }


        return binding.root
    }
}
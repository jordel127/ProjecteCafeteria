package com.jordel.projectecafeteria.Home.Begudes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.jordel.projectecafeteria.Home.Menjars.VMMenjar
import com.jordel.projectecafeteria.Home.SharedViewModel
import com.jordel.projectecafeteria.Home.productesModel
import com.jordel.projectecafeteria.R
import com.jordel.projectecafeteria.databinding.FragmentBegudesBinding


class BegudesFragment : Fragment() {
    val sharedViewModel: SharedViewModel by activityViewModels()
    val vmBeguda: VMBegudes by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentBegudesBinding.inflate(inflater)

        vmBeguda.obtenerProducto(1)?.let {
            binding.textViewProd1.text = it.nom
            val price = it.preu.toDoubleOrNull() ?: 0.0
            binding.textViewpreu1.text = String.format("%.2f€", price)
            binding.editTextNumber1.setText(it.cantitat.toString())
        }
        vmBeguda.obtenerProducto(2)?.let {
            binding.textViewProd2.text = it.nom
            val price = it.preu.toDoubleOrNull() ?: 0.0
            binding.textViewpreu2.text = String.format("%.2f€", price)
            binding.editTextNumber2.setText(it.cantitat.toString())
        }
        vmBeguda.obtenerProducto(3)?.let {
            binding.textViewProd3.text = it.nom
            val price = it.preu.toDoubleOrNull() ?: 0.0
            binding.textViewpreu3.text = String.format("%.2f€", price)
            binding.editTextNumber3.setText(it.cantitat.toString())
        }
        vmBeguda.obtenerProducto(4)?.let {
            binding.textViewProd4.text = it.nom
            val price = it.preu.toDoubleOrNull() ?: 0.0
            binding.textViewpreu4.text = String.format("%.2f€", price)
            binding.editTextNumber4.setText(it.cantitat.toString())
        }

        binding.buttonSave.setOnClickListener {
            val product1Quantity = binding.editTextNumber1.text.toString()
            val product2Quantity = binding.editTextNumber2.text.toString()
            val product3Quantity = binding.editTextNumber3.text.toString()
            val product4Quantity = binding.editTextNumber4.text.toString()

            val product1QuantityInt = product1Quantity.toIntOrNull() ?: 0
            val product2QuantityInt = product2Quantity.toIntOrNull() ?: 0
            val product3QuantityInt = product3Quantity.toIntOrNull() ?: 0
            val product4QuantityInt = product4Quantity.toIntOrNull() ?: 0

            if (product1Quantity == "") {
                binding.editTextNumber1.setText("0")
            }
            if (product2Quantity == "") {
                binding.editTextNumber2.setText("0")
            }
            if (product3Quantity == "") {
                binding.editTextNumber3.setText("0")
            }
            if (product4Quantity == "") {
                binding.editTextNumber4.setText("0")
            }

            // Creamos los productos basados en los valores (aún si son 0)
            val product1 = productesModel(vmBeguda.productes[0].tipus,vmBeguda.productes[0].nom, vmBeguda.productes[0].preu, product1QuantityInt)
            val product2 = productesModel(vmBeguda.productes[1].tipus,vmBeguda.productes[1].nom, vmBeguda.productes[1].preu, product2QuantityInt)
            val product3 = productesModel(vmBeguda.productes[2].tipus,vmBeguda.productes[2].nom, vmBeguda.productes[2].preu, product3QuantityInt)
            val product4 = productesModel(vmBeguda.productes[3].tipus,vmBeguda.productes[3].nom, vmBeguda.productes[3].preu, product4QuantityInt)

            // Guardamos los productos en el SharedViewModel
            sharedViewModel.addItem(product1)
            sharedViewModel.addItem(product2)
            sharedViewModel.addItem(product3)
            sharedViewModel.addItem(product4)

            Toast.makeText(context, "Productos guardados", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }
}
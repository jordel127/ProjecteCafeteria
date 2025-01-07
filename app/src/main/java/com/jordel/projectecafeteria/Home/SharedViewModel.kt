package com.jordel.projectecafeteria.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _selectedItems = MutableLiveData<List<productesModel>>().apply { value = mutableListOf() }
    val selectedItems: LiveData<List<productesModel>> get() = _selectedItems

    private val _totalAmount = MutableLiveData<Double>().apply { value = 0.0 }
    val totalAmount: LiveData<Double> get() = _totalAmount

    fun addItem(product: productesModel) {
        val currentList = _selectedItems.value?.toMutableList() ?: mutableListOf()
        val existingProductIndex = currentList.indexOfFirst { it.nom == product.nom }

        if (existingProductIndex != -1) {
            // Replace the existing product with the updated quantity
            currentList[existingProductIndex] = product
        } else {
            // Add the new product
            currentList.add(product)
        }

        _selectedItems.value = currentList
        updateTotalAmount()
    }

    private fun updateTotalAmount() {
        _totalAmount.value = _selectedItems.value?.sumOf { it.preu.toDouble() * it.cantitat } ?: 0.0
    }
}
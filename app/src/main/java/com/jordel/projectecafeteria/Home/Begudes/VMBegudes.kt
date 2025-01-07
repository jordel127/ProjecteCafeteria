package com.jordel.projectecafeteria.Home.Begudes

import androidx.lifecycle.ViewModel
import com.jordel.projectecafeteria.Home.ProductesProvider
import com.jordel.projectecafeteria.Home.productesModel

class VMBegudes : ViewModel() {
    private val _productes = ProductesProvider.obtenirTipusProductes("beguda").toMutableList()
    val productes: List<productesModel> get() = _productes

    fun obtenerProducto (numero: Int): productesModel? {
        return _productes.getOrNull(numero -1)
    }
}
package com.jordel.projectecafeteria.Home.Menjars

import androidx.lifecycle.ViewModel
import com.jordel.projectecafeteria.Home.ProductesProvider
import com.jordel.projectecafeteria.Home.productesModel

class VMMenjar : ViewModel() {

    private val _productes = ProductesProvider.obtenirTipusProductes("menjar").toMutableList()
    val productes: List<productesModel> get() = _productes

    fun obtenerProducto (numero: Int): productesModel? {
        return _productes.getOrNull(numero -1)
    }
}
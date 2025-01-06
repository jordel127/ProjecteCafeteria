package com.jordel.projectecafeteria.usuaris_I_Identificacio

import androidx.lifecycle.ViewModel

class RegistreVM : ViewModel() {

    fun crearUsuario(nombre: String, contrasenya: String){
        UsuarisProvider.añadirNuevoUsuario(UsuarisModel(nombre, contrasenya))
    }
}
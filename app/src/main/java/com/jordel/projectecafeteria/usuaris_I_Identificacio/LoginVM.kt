package com.jordel.projectecafeteria.usuaris_I_Identificacio

import androidx.lifecycle.ViewModel

class LoginVM : ViewModel() {

    fun logIn(nombreUsuario: String, contrasenyaUsuario: String): Boolean {
        val usuario = UsuarisProvider.obtenerUsiario(nombreUsuario)

        if(usuario == null){
            return false
        }else if(usuario.contrasenya != contrasenyaUsuario){
            return false
        }
        return true
    }
}
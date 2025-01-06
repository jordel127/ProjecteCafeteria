package com.jordel.projectecafeteria.usuaris_I_Identificacio

class UsuarisProvider {
    companion object {
        fun añadirNuevoUsuario(usuario: UsuarisModel){
            usuaris.add(usuario)
        }
        fun obtenerUsiario(nom: String): UsuarisModel? {
            return usuaris.find { it.nom == nom }
        }


        private val usuaris = mutableListOf(
            UsuarisModel(
                nom = "Joel",
                contrasenya = "1212"
            ),
            UsuarisModel(
                nom = "Maria",
                contrasenya = "1234"
            ),
            UsuarisModel(
                nom = "Pepe",
                contrasenya = "1234"
            ),
            UsuarisModel(
                nom = "Juan",
                contrasenya = "1234"
            )
        )
    }
}
package com.jordel.projectecafeteria.Home

class ProductesProvider {
    companion object {
        fun obtenirTipusProductes(Tipus: String): List<productesModel> {
            return productes.filter { it.tipus == Tipus }
        }

        private val productes = mutableListOf(
            productesModel(
                tipus = "menjar",
                nom = "canelones",
                preu = "5",
                cantitat = 0
            ),
            productesModel(
                tipus = "menjar",
                nom = "ensalada",
                preu = "15",
                cantitat = 0
            ),
            productesModel(
                tipus = "menjar",
                nom = "sopa",
                preu = "9",
                cantitat = 0
            ),
            productesModel(
                tipus = "menjar",
                nom = "croquetas",
                preu = "10",
                cantitat = 0
            ),
            productesModel(
                tipus = "beguda",
                nom = "aigua",
                preu = "12",
                cantitat = 0
            ),
            productesModel(
                tipus = "beguda",
                nom = "cocacola",
                preu = "12",
                cantitat = 0
            ),
            productesModel(
                tipus = "beguda",
                nom = "Fanta",
                preu = "10",
                cantitat = 0
            ),
            productesModel(
                tipus = "beguda",
                nom = "nestea",
                preu = "12",
                cantitat = 0
            ),
            productesModel(
                tipus = "postre",
                nom = "gelat",
                preu = "12",
                cantitat = 0
            ),
            productesModel(
                tipus = "postre",
                nom = "cheesecake",
                preu = "12",
                cantitat = 0
            ), productesModel(
                tipus = "postre",
                nom = "gelatina",
                preu = "12",
                cantitat = 0
            ),
            productesModel(
                tipus = "postre",
                nom = "melo",
                preu = "12",
                cantitat = 0
            )
        )
    }

}
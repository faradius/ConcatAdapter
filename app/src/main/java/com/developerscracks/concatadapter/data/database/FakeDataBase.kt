package com.developerscracks.concatadapter.data.database

import com.developerscracks.concatadapter.data.model.Pelicula

object FakeDataBase {
    fun peliculas(): MutableList<Pelicula>{
        return mutableListOf(
            Pelicula("Avengers: Endgame", "Populares"),
            Pelicula("Parasite", "Populares"),
            Pelicula("Joker", "Populares"),
            Pelicula("The Shape of Water", "Nuevas"),
            Pelicula("La La Land", "Nuevas"),
            Pelicula("Black Panther", "Populares"),
            Pelicula("Interstellar", "Populares"),
            Pelicula("Inception", "Populares"),
            Pelicula("The Dark Knight", "Populares"),
            Pelicula("The Shawshank Redemption", "Populares"),
            Pelicula("Pulp Fiction", "Populares"),
            Pelicula("Fight Club", "Populares"),
            Pelicula("The Godfather", "Populares"),
            Pelicula("The Matrix", "Populares"),
            Pelicula("Titanic", "Populares"),
            Pelicula("Forrest Gump", "Populares"),
            Pelicula("The Lion King", "Nuevas"),
            Pelicula("Toy Story", "Nuevas"),
            Pelicula("Coco", "Nuevas"),
            Pelicula("La La Land", "Nuevas")
        )
    }
}
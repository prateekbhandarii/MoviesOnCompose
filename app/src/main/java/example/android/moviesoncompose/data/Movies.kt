package example.android.moviesoncompose.data

import example.android.moviesoncompose.R

data class Movies(
    val id: Int,
    val name: String,
    val description: String,
    val image: Int,
    val rating: Double
)

fun Movies.getDummyData(): List<Movies> {
    return listOf(
        Movies(
            1,
            "The Godfather",
            "Cheese on toast airedale the big cheese. Danish fontina cheesy grin airedale danish fontina taleggio the big cheese macaroni cheese port-salut. Edam fromage lancashire feta caerphilly.",
            R.drawable.sample_movie_thumbnail,
            7.5
        ),
        Movies(
            1,
            "Eternals",
            "Cheese on toast airedale the big cheese. Danish fontina cheesy grin airedale danish fontina taleggio the big cheese macaroni cheese port-salut.",
            R.drawable.sample_movie_thumbnail,
            7.5
        )
    )
}

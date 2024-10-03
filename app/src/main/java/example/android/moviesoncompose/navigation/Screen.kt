package example.android.moviesoncompose.navigation

sealed class Screen(val route:String) {
    data object TopMovies: Screen("top_movies")
    data object MovieDetails: Screen("movie_details")
}
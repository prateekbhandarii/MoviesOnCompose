package example.android.moviesoncompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import example.android.moviesoncompose.activity.MovieDetailsActivity
import example.android.moviesoncompose.activity.TopMoviesActivity
import example.android.moviesoncompose.data.Movie

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.TopMovies.route) {
        composable(route = Screen.TopMovies.route) {
            TopMoviesActivity(navController)
        }
        composable(
            route = Screen.MovieDetails.route,
            arguments = listOf(
                navArgument("movie") {
                    type = NavType.ParcelableType(Movie::class.java)
                }
            )
        ) {
            MovieDetailsActivity()
        }
    }
}
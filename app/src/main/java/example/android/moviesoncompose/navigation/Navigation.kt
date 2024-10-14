package example.android.moviesoncompose.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.Navigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import example.android.moviesoncompose.activity.MovieDetailsActivity
import example.android.moviesoncompose.activity.TopMoviesActivity
import example.android.moviesoncompose.data.Movie
import example.android.moviesoncompose.data.MovieParamType

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
                    type = MovieParamType()
                }
            )
        ) {
            val movie = it.arguments?.getParcelable<Movie>("movie")
            if (movie != null)
                MovieDetailsActivity(navController, movie)
        }
    }
}

fun NavController.navigate(
    route: String,
    args: Bundle,
    navOptions: NavOptions? = null,
    navigatorExtra: Navigator.Extras? = null
) {
    val nodeId = graph.findNode(route = route)?.id
    nodeId?.let {
        navigate(nodeId, args, navOptions, navigatorExtra)
    }
}

//fun NavController.navigateWithDeepLink(
//    route: String,
//    args: Bundle,
//    navOptions: NavOptions? = null,
//    navigatorExtras: Navigator.Extras? = null
//) {
//    val routeLink = NavDeepLinkRequest
//        .Builder
//        .fromUri(NavDestination.createRoute(route).toUri())
//        .build()
//
//    val deepLinkMatch = graph.matchDeepLink(routeLink)
//    if (deepLinkMatch != null) {
//        val destination = deepLinkMatch.destination
//        val id = destination.id
//        navigate(id, args, navOptions, navigatorExtras)
//    } else {
//        navigate(route, navOptions, navigatorExtras)
//    }
//}
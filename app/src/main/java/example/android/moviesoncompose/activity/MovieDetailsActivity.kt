package example.android.moviesoncompose.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import example.android.moviesoncompose.R
import example.android.moviesoncompose.composable.Toolbar
import example.android.moviesoncompose.data.Movie
import example.android.moviesoncompose.navigation.Screen
import example.android.moviesoncompose.ui.theme.MoviesOnComposeTheme

class MovieDetailsActivity(private val navController: NavController, private val movie: Movie) :
    ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        enableEdgeToEdge()
        setContent {
            MoviesOnComposeTheme {
                ShowMovieDetails(
                    navController, movie = movie
                )
            }
        }
    }
}

@Composable
fun ShowMovieDetails(navController: NavController?, movie: Movie) {
    Scaffold(topBar = {
        Toolbar(text = {
            Text(
                text = "title",
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Justify,
                fontSize = 24.sp,
            )
        }, backgroundColor = colorResource(R.color.white), leftIcon = {
            IconButton(onClick = {
                navController?.navigateUp()
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "back button",
                    tint = colorResource(id = R.color.search_bar_purple)
                )
            }
        })
    }) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(contentPadding),
        ) {
            val imageState = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current).data(movie.backdrop_path)
                    .size(Size.ORIGINAL).build()
            ).state
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailsPreview() {
    ShowMovieDetails(null, Movie(
        false,
        "/kXfqcdQKsToO0OUXHcrrNCHDBzO.jpg",
        listOf(18, 80),
        278,
        "en",
        "The Shawshank Redemption",
        "Imprisoned in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.",
        204.296,
        "/9cqNxx0GxF0bflZmeSMuL5tnGzr.jpg",
        "1994-09-23",
        "The Shawshank Redemption",
        false,
        8.706,
        26843
    ))
}
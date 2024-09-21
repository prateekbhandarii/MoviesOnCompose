package example.android.moviesoncompose.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import example.android.moviesoncompose.R
import example.android.moviesoncompose.composable.MovieListItem
import example.android.moviesoncompose.composable.SearchBar
import example.android.moviesoncompose.data.Movies
import example.android.moviesoncompose.ui.theme.MoviesOnComposeTheme

class MainActivity : ComponentActivity() {

    private val moviesList = listOf(
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
            7.9
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoviesOnComposeTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MoviesList(
                        moviesList
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesList(list: List<Movies>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Top Movies") },
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(contentPadding),
        ) {
            SearchBar()
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
            ) {
                items(list) { movie ->
                    MovieListItem(movie)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    MoviesList(listOf(Movies(1, "Godfather", "desc", R.drawable.sample_movie_thumbnail, 7.5)))
}
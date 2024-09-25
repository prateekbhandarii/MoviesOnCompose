package example.android.moviesoncompose.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import example.android.moviesoncompose.composable.MovieListItem
import example.android.moviesoncompose.composable.SearchBar
import example.android.moviesoncompose.data.Movie
import example.android.moviesoncompose.network.RetrofitObject
import example.android.moviesoncompose.repository.MoviesRepositoryImpl
import example.android.moviesoncompose.ui.theme.MoviesOnComposeTheme
import kotlinx.coroutines.flow.collectLatest

class MainActivity : ComponentActivity() {

    companion object {
        fun getDummyObject(): Movie {
            return Movie(
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
            )
        }
    }

    private val viewModel by viewModels<MainViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MainViewModel(MoviesRepositoryImpl(RetrofitObject.moviesService)) as T
            }
        }
    })

    private var moviesList = emptyList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoviesOnComposeTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    moviesList = viewModel.movies.collectAsState().value
                    val context = LocalContext.current

                    LaunchedEffect(key1 = viewModel.showErrorToastChannel) {
                        viewModel.showErrorToastChannel.collectLatest { show ->
                            if (show) {
                                Toast.makeText(
                                    context,
                                    "Something went wrong!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }

                    if (moviesList.isEmpty()) {
                        Toast.makeText(
                            context,
                            "Loading!!",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        MoviesList(
                            moviesList
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesList(list: List<Movie>) {
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
    MoviesList(listOf(MainActivity.getDummyObject()))
}
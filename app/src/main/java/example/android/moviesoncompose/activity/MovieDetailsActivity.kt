package example.android.moviesoncompose.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import example.android.moviesoncompose.ui.theme.MoviesOnComposeTheme

class MovieDetailsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        enableEdgeToEdge()
        setContent {
            MoviesOnComposeTheme {
                ShowMovieDetails()
            }
        }
    }
}

@Composable
fun ShowMovieDetails(){

}

@Preview(showBackground = true)
@Composable
fun MovieDetailsPreview() {
    ShowMovieDetails()
}
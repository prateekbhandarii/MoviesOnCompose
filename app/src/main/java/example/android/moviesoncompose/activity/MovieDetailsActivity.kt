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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import example.android.moviesoncompose.R
import example.android.moviesoncompose.composable.Toolbar
import example.android.moviesoncompose.ui.theme.MoviesOnComposeTheme

class MovieDetailsActivity(private val navController: NavController) : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        enableEdgeToEdge()
        setContent {
            MoviesOnComposeTheme {
                ShowMovieDetails(navController)
            }
        }
    }
}

@Composable
fun ShowMovieDetails(navController: NavController?) {
    Scaffold(topBar = {
        Toolbar(
            text = {
                Text(
                    text = "title",
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Justify,
                    fontSize = 24.sp,
                )
            },
            backgroundColor = colorResource(R.color.white),
            leftIcon = {
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

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailsPreview() {
    ShowMovieDetails(null)
}
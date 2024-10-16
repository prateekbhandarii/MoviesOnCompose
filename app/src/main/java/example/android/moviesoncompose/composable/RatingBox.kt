package example.android.moviesoncompose.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import example.android.moviesoncompose.R
import example.android.moviesoncompose.data.Movie

@Composable
fun RatingBox(movie: Movie, modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        Row {
            Icon(
                painter = painterResource(R.drawable.rating_star),
                contentDescription = "Rating logo",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
            Spacer(
                modifier = Modifier.size(5.dp)
            )
            Text(
                text = movie.vote_average.toString(), color = Color.White, fontSize = 16.sp
            )
        }
    }
}
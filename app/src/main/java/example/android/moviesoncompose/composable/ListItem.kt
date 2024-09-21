package example.android.moviesoncompose.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import example.android.moviesoncompose.R
import example.android.moviesoncompose.data.Movies

@Composable
fun MovieListItem(movie: Movies) {
    Row(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
        ) {
            Image(
                painter = painterResource(movie.image),
                contentDescription = "Movie thumbnail",
                modifier = Modifier
                    .size(width = 92.dp, height = 134.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.size(10.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.Black)
                    .padding(5.dp)
            ) {
                Row {
                    Icon(
                        painter = painterResource(R.drawable.rating_star),
                        contentDescription = "Rating logo",
                        tint = Color.White,
                        modifier = Modifier
                            .size(16.dp)
                    )
                    Spacer(
                        modifier = Modifier.size(5.dp)
                    )
                    Text(
                        text = movie.rating.toString(),
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .padding(start = 16.dp)
        ) {
            Text(
                text = movie.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                color = Color.DarkGray,
                text = movie.description,
                lineHeight = 20.sp,
                fontSize = 16.sp,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MovieListItemPreview() {
    MovieListItem(
        Movies(
            1,
            "The Godfather",
            "Cheese on toast airedale the big cheese. Danish fontina cheesy grin airedale danish fontina taleggio the big cheese macaroni cheese port-salut. Edam fromage lancashire feta caerphilly.",
            R.drawable.sample_movie_thumbnail,
            7.5
        )
    )
}
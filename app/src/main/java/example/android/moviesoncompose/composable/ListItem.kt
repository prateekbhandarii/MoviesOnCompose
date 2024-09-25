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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import example.android.moviesoncompose.R
import example.android.moviesoncompose.activity.MainActivity
import example.android.moviesoncompose.data.Movie

@Composable
fun MovieListItem(movie: Movie) {
    Row(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
        ) {
            val imageState = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(movie.poster_path)
                    .size(Size.ORIGINAL).build()
            ).state

            ShowPosterImage(
                imageState = imageState,
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
                        text = movie.vote_average.toString(),
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
                text = movie.original_title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                color = Color.DarkGray,
                text = movie.overview,
                lineHeight = 20.sp,
                fontSize = 16.sp,
            )
        }
    }
}

@Composable
private fun ShowPosterImage(imageState: AsyncImagePainter.State, modifier: Modifier) {
    if (imageState is AsyncImagePainter.State.Success) {
        Image(
            painter = imageState.painter,
            contentDescription = "Movie thumbnail",
            modifier = modifier
        )
    } else {
        Box(modifier = modifier, contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}

@Preview
@Composable
fun ItemPreview() {
    MovieListItem(movie = MainActivity.getDummyObject())
}
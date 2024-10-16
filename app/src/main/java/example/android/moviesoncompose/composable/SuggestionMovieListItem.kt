package example.android.moviesoncompose.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import example.android.moviesoncompose.activity.TopMoviesActivity
import example.android.moviesoncompose.data.Movie

@Composable
fun SuggestionMovieListItem(movie: Movie) {
    Row {
        Column(
            modifier = Modifier
                .width(144.dp)
                .wrapContentHeight()
                .background(Color.White)
        ) {
            val posterImageState = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(movie.poster_path)
                    .size(Size.ORIGINAL).build()
            ).state

            ShowPosterImage(
                imageState = posterImageState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(212.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Red)
            )

            Spacer(modifier = Modifier.size(10.dp))

            Text(
                text = movie.original_title,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
            )

            Spacer(modifier = Modifier.size(2.dp))

            Text(
                text = "Genre * Genre",
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.size(10.dp))

            RatingBox(
                movie = movie,
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.Black)
                    .padding(5.dp)
            )
        }

        Spacer(Modifier.size(8.dp))
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
fun SuggestionPreview() {
    SuggestionMovieListItem(movie = TopMoviesActivity.getDummyObject())
}
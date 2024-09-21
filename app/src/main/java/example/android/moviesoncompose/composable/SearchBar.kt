package example.android.moviesoncompose.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import example.android.moviesoncompose.R

@Composable
fun SearchBar() {

    var searchQuery by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = searchQuery,
        onValueChange = {
            searchQuery = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
            .background(Color.Transparent)
        ,
        shape = RoundedCornerShape(8.dp),
        singleLine = true,
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.search_icon),
                contentDescription = "search_icon",
                tint = colorResource(R.color.search_bar_purple)
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(R.drawable.movie_search_filter),
                contentDescription = "search_filter_icon",
                tint = colorResource(R.color.search_bar_purple)
            )
        },
    )
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    SearchBar()
}
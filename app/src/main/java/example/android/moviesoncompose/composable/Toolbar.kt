package example.android.moviesoncompose.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(
    text: (@Composable () -> Unit) = { Text(text = "Title") },
    backgroundColor: Color,
    elevation: Dp = 4.dp,
    leftIcon: (@Composable () -> Unit)? = null,
    rightIcon: (@Composable () -> Unit)? = null
) {
    Surface(shadowElevation = elevation) {
        TopAppBar(
            modifier = Modifier.fillMaxWidth(),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = backgroundColor,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                actionIconContentColor = MaterialTheme.colorScheme.onSecondary
            ),
            title = {
                text()
            },
            navigationIcon = {
                if (leftIcon != null) leftIcon()
            },
            actions = {
                if (rightIcon != null) rightIcon()
            }
        )
    }
}

@Preview
@Composable
fun ToolbarPreview() {
    Toolbar(text = {
        Text(
            text = "title",
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Justify,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
        )
    }, backgroundColor = Color.White, leftIcon = {
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                tint = Color.Black,
                contentDescription = "back button"
            )
        }
    })
}
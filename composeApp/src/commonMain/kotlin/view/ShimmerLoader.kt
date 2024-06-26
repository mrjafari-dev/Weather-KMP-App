package view
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun ShimmerLoader(modifier: Modifier = Modifier) {

    var shimmerState = remember { mutableStateOf(true) }
    val infiniteTransition = rememberInfiniteTransition()
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.2f, targetValue = 0.8f, animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 700, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val coroutineScope = rememberCoroutineScope()

    // Simulate loading delay
    LaunchedEffect(key1 = true) {
        delay(5) // Adjust the delay time as needed
        coroutineScope.launch {
            shimmerState.value = false
        }
    }
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
    ) {
        Box(
            modifier = modifier
        ) {
            val gradient = Brush.horizontalGradient(
                colors = listOf(Color.Gray.copy(alpha = alpha), Color.Gray.copy(alpha = 0.2f))
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(brush = gradient)
                    .clip(CircleShape),
                contentAlignment = Alignment.Center
            ) {
                if (shimmerState.value == true) {
                    Spacer(
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth()
                            .background(Color(0x00008888))
                    )
                }
            }
        }
    }

}
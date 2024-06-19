import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import io.ktor.client.*
import io.ktor.client.call.*
import model.RequestModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import remote.PostServiceImp

import weatherapp.composeapp.generated.resources.Res
import weatherapp.composeapp.generated.resources.compose_multiplatform

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {

        val client = HttpClient()
        val viewModel : AppViewModel = viewModel{AppViewModel()}
        val viewState = viewModel.weatherViewState.collectAsState().value
        val requestModel = RequestModel(country = "IR", city = "tehran")
        var bottomSheetViewState by remember { mutableStateOf(false) }
        Column {
            when (viewState) {
                is MainViewState.LoadingState -> {
                    // Show loading indicator
                    Text("Loading weather data...")
                }
                is MainViewState.DataLoadedState -> {
                    val weatherData = viewState.data
                    // Display weather information using weatherData
                    Text("City: ${weatherData.data}")
                    Text("Temperature: ${weatherData.count}")
                    // ... display other weather details
                }
                else -> {
                    // Handle potential error state
                    Text("Error fetching weather data")
                }
            }
            Button(onClick = {
                bottomSheetViewState = !bottomSheetViewState
            }){
                Text("Click")
            }
            if (bottomSheetViewState){
                Flexi


            }
        }

        LaunchedEffect(true){
            viewModel.getWeather(requestModel)

        }



    }
}
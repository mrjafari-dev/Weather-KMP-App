import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import model.RequestModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import view.SearchBox
import viewModel.AppViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {

        val viewModel : AppViewModel = viewModel{ AppViewModel() }
        val viewState = viewModel.weatherViewState.collectAsState().value
        val requestModel = RequestModel(country = "IR", city = "tehran")


        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val widthFraction = when {
                maxWidth > 600.dp -> 0.5f // Desktop
                maxWidth > 400.dp -> 0.5f // Tablet
                else -> 1f // Mobile
            }
            Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                Column(modifier = Modifier.fillMaxWidth(widthFraction).padding(top = 10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Row {
                        SearchBox(){
                            requestModel.city = it
                            viewModel.fetchData(requestModel)
                        }
                    }
                    when (viewState) {
                        is MainViewState.LoadingState -> {
                            // Show loading indicator
                            Text("Loading weather data...")
                        }
                        is MainViewState.DataLoadedState -> {
                            val weatherData = viewState.data
                            // Display weather information using weatherData
                            Text("City: ${weatherData.current}")
                            Text("Temperature: ${weatherData.location}")
                            println("https://".plus(weatherData.current.condition.icon.removePrefix("//")))
                            AsyncImage(modifier = Modifier
                                .size(250.dp)
                                .padding(16.dp),
                                model = "https://".plus(weatherData.current.condition.icon.removePrefix("//")),
                                contentDescription = null)
                            // ... display other weather details
                        }
                        else -> {
                            // Handle potential error state
                            Text("Error fetching weather data")
                        }
                    }



                }
            }


        }






    }
}
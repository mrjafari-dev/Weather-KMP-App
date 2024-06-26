import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import model.RequestModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import view.MainLoading
import view.SearchBox
import view.DisplayWeatherInfo
import view.MainView
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
                maxWidth > 600.dp -> 0.6f // Desktop
                maxWidth > 400.dp -> 0.8f // Tablet
                else -> 0.9f // Mobile
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
                            MainLoading()
                        }
                        is MainViewState.DataLoadedState -> {
                            val weatherData = viewState.data
                            MainView(viewModel,weatherData)
                        }
                        else -> {
                            Text("Error fetching weather data")
                        }
                    }



                }
            }


        }






    }
}
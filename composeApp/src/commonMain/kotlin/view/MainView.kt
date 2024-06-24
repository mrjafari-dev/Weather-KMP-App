package view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import model.WeatherResponse
import viewModel.AppViewModel

@Composable
fun MainView(appViewModel: AppViewModel){

}

@Composable
fun TemperoryPackView(appViewModel: AppViewModel , weatherResponse: WeatherResponse){
    Row(modifier = Modifier.fillMaxWidth().padding(top = 20.dp), horizontalArrangement = Arrangement.Start) {
        AsyncImage(modifier = Modifier
            .size(200.dp)
            .padding(16.dp),
            model = "https://".plus(weatherResponse.current.condition.icon.removePrefix("//")),
            contentDescription = null)
        Column(modifier = Modifier.padding(start = 10.dp)) {
            Text(weatherResponse.current.temp_c.toString().plus("C") , fontSize = 48.sp)
            Text("${weatherResponse.location.country} / ${weatherResponse.location.name}" , fontSize = 12.sp)
            Text(appViewModel.getWeatherMessage(weatherResponse.current.temp_c), fontSize = 12.sp)

        }
    }
}
package view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import model.WeatherResponse
import viewModel.AppViewModel
import weatherapp.composeapp.generated.resources.Res
import weatherapp.composeapp.generated.resources.dosis
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import weatherapp.composeapp.generated.resources.placeholder
import weatherapp.composeapp.generated.resources.schedule

@Composable
fun MainView(appViewModel: AppViewModel, weatherResponse: WeatherResponse) {
    Column {
        DisplayWeatherInfo(appViewModel, weatherResponse)
       // CountryTimeInfo(appViewModel, weatherResponse)

    }
}

@Composable
fun DisplayWeatherInfo(appViewModel: AppViewModel, weatherResponse: WeatherResponse) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1.3f)) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                model = "https://".plus(
                    weatherResponse.current.condition.icon.removePrefix("//").replace("64x64", "128x128")
                ),
                contentDescription = null
            )
        }

        Column(modifier = Modifier.padding(start = 10.dp).weight(1.5f)) {

            Text(
                weatherResponse.current.temp_c.toString().plus(" °C"),
                fontSize = 42.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily(Font(Res.font.dosis, weight = FontWeight.ExtraBold))
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(Res.drawable.schedule), contentDescription = null,modifier = Modifier.size(15.dp))
                Text(
                    weatherResponse.location.localtime,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(Res.font.dosis)),
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(Res.drawable.placeholder), contentDescription = null, modifier = Modifier.size(15.dp))
                Text(
                    "${weatherResponse.location.country} / ${weatherResponse.location.name}",
                    fontWeight = FontWeight.Black,
                    fontSize = 12.sp, fontFamily = FontFamily(Font(Res.font.dosis)),
                    modifier = Modifier.padding(start = 5.dp)

                )
            }

            Spacer(modifier = Modifier.height(20.dp))

        }
    }
}

@Composable
fun CountryTimeInfo(appViewModel: AppViewModel, weatherResponse: WeatherResponse) {
    Row(modifier = Modifier.fillMaxWidth().padding(start = 20.dp), horizontalArrangement = Arrangement.Start) {
        /*  AsyncImage(
              modifier = Modifier
                  .size(60.dp)
                  .padding(16.dp),
              model = appViewModel.getCountryFlag(weatherResponse.location.country),
              contentDescription = null
          )*/
        Text(
            weatherResponse.location.localtime,
            fontSize = 42.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily(Font(Res.font.dosis, weight = FontWeight.ExtraBold))
        )
    }
}
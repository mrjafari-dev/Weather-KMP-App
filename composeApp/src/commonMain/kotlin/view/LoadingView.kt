package view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainLoading(){
   Column(modifier = Modifier.padding(top = 50.dp)) {
       DisplayWeatherInfoLoading()
       Spacer(modifier = Modifier.height(10.dp))
       DisplayWeatherDetailLoading()
   }
}
@Composable
fun DisplayWeatherInfoLoading(){
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
        ShimmerLoader(modifier = Modifier.size(150.dp))
        Column(verticalArrangement = Arrangement.Center) {
            ShimmerLoader(modifier = Modifier.height(40.dp).fillMaxWidth(0.3f))
            Spacer(modifier = Modifier.height(10.dp))
            ShimmerLoader(modifier = Modifier.height(20.dp).fillMaxWidth(0.6f))
            Spacer(modifier = Modifier.height(10.dp))
            ShimmerLoader(modifier = Modifier.height(10.dp).fillMaxWidth(0.8f))
        }
    }

}

@Composable
fun DisplayWeatherDetailLoading(){
    LazyRow {
        items(3){
            ShimmerLoader(modifier = Modifier.height(100.dp).width(140.dp))

        }
    }
}
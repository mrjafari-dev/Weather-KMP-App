package view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MainLoading(){
   Column(modifier = Modifier.padding(top = 50.dp)) {
       IconLoadingView()
   }
}
@Composable
fun IconLoadingView(){
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
        ShimmerLoader(modifier = Modifier.size(70.dp))
        Column(verticalArrangement = Arrangement.Center) {
            ShimmerLoader(modifier = Modifier.height(10.dp).fillMaxWidth(0.8f))
            Spacer(modifier = Modifier.height(10.dp))
            ShimmerLoader(modifier = Modifier.height(10.dp).fillMaxWidth(0.8f))
            Spacer(modifier = Modifier.height(10.dp))
            ShimmerLoader(modifier = Modifier.height(10.dp).fillMaxWidth(0.8f))
        }
    }

}
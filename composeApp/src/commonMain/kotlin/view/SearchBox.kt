package view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import weatherapp.composeapp.generated.resources.Res



@Composable
fun SearchBox(onClick: (String) -> Unit) {
    var searchValue by remember {
        mutableStateOf("")
    }
    Card(elevation = 5.dp, modifier = Modifier.height(45.dp), shape = RoundedCornerShape(50.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
            BasicTextField(value = searchValue, onValueChange = {
                searchValue = it
            }, modifier = Modifier.weight(1.5f).padding(start = 10.dp))
            Card(
                backgroundColor = Color.Black,
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.size(35.dp).clickable {
                    onClick(searchValue)
                }
                    .size(70.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                 /*   Image(
                        painter = painterResource(Res.drawable.),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )*/
                }
            }
        }
    }

}
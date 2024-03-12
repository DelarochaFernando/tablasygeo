package com.delarochaf.tablasygeo.cursoudemy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun MyComplexLayOutPreview(){
    MyComplexLayout()
}


@Composable
fun MySpacer(size:Int){
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyComplexLayout(){

    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Cyan),
            contentAlignment = Alignment.Center) {
            Text(text = "Ejemplo 1")
        }
        MySpacer(size = 30)
        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) {
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 2")
            }
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Red),
                contentAlignment = Alignment.Center) {
                Text(text = "Ejemplo 3")
            }
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter) {
            Text(text = "Ejemplo 4")
        }
    }
}
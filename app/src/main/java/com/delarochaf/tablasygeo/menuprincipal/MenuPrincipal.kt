package com.delarochaf.tablasygeo.menuprincipal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.delarochaf.tablasygeo.R
import com.delarochaf.tablasygeo.ui.theme.TablasygeoTheme

@Composable
fun MenuPrincipal(navController: NavController){
    TablasygeoTheme() {
        //MenuJuego(navController)
    }
}

//@Preview(showBackground = true)
@Composable
fun MenuJuego(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.teal_200))) {
        Text(
            text = "Elige el tipo de juego en que quieras participar:",
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 16.dp),
            color = Color.White
        )
        Spacer(modifier = Modifier.padding(0.dp,25.dp))

    }

}


@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun CardGameOption(navController: NavController,text:String){
    Card(
        shape = RoundedCornerShape(CornerSize(4.dp)),
        onClick = {navController}

    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(45.dp)){
            Spacer(modifier = Modifier.padding(4.dp))
            Image(
                painter= painterResource(id = R.drawable.ic_geography_light),
                contentDescription = "logo Tablas",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(65.dp)

            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = text,
                fontSize = 50.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}


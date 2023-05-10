package com.delarochaf.tablasygeo.menuprincipal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.OutlinedCard
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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.delarochaf.tablasygeo.R
import com.delarochaf.tablasygeo.ui.theme.TablasygeoTheme

@Composable
fun MenuPrincipal(navController: NavController){
    TablasygeoTheme() {
        MenuJuego(navController)
    }
}

//@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuJuego(navController: NavController){
    val geoImg = painterResource(id = R.drawable.menu_geography_kids_logo1)
    val mathImg = painterResource(id = R.drawable.menu_math_kids_logo1)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.green_chalkboard))
    ) {
        Text(
            text = "Juegos",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(12.dp, 100.dp),
            color = Color.White,
            fontSize = 40.sp
        )
        CardGameOptionHorizontal(
            navController = navController,
            category = "Matemáticas",
            painterRes = mathImg,
            routeText = "mathScreenMenu"
        )

        CardGameOptionHorizontal(
            navController = navController,
            category = "Geografía",
            painterRes = geoImg,
            routeText = "geographyScreen"
        )
    }

}


@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun CardGameOptionHorizontal(
    navController: NavController,
    category: String,
    painterRes: Painter,
    routeText : String
){
    Card(
        shape = RoundedCornerShape(CornerSize(4.dp)),
        onClick = {navController.navigate(routeText) }

    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(45.dp)){
            Spacer(modifier = Modifier.padding(4.dp))
            Image(
                painter= painterRes,
                contentDescription = category,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(65.dp)

            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = category,
                fontSize = 50.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}



@ExperimentalMaterial3Api
//@Preview(showBackground = true)
@Composable
fun CardGameOptionVertical(
    navController: NavController,
    category: String,
    painterRes: Painter,
    routeText : String
){
    OutlinedCard(
        shape = RoundedCornerShape(CornerSize(12.dp)),
        onClick = {
            navController.navigate(routeText)
        }
    ) {
        Column(verticalArrangement = Arrangement.SpaceEvenly) {
            Row(modifier = Modifier
                .padding(0.dp, 32.dp, 0.dp, 0.dp)
                .fillMaxWidth()){
                Image(
                    painter= painterRes,
                    contentDescription = category,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.size(405.dp,200.dp)
                )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 15.dp, 0.dp, 32.dp)
            ){
                Text(
                    text = category,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    fontSize = 55.sp
                )
            }
        }

    }

}


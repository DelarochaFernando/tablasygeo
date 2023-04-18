package com.delarochaf.tablasygeo.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.delarochaf.tablasygeo.R
import com.delarochaf.tablasygeo.ui.theme.TablasygeoTheme
import java.lang.Float

@Composable
fun Splash_Screen(navController : NavController){

    TablasygeoTheme() {
        splashScreenPreview()
    }

}

@Preview
@Composable
fun splashScreenPreview(){
    simpleSplashScreen()
}

@Composable
fun simpleSplashScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imgresource : Painter = painterResource(id = R.drawable.logotabygeotemporal)
        Image(
            painter = imgresource, contentDescription = "LogoApp",
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
        )
    }
}
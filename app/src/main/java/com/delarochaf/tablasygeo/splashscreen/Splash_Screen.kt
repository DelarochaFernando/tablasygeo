package com.delarochaf.tablasygeo.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Interests
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.delarochaf.tablasygeo.R
import com.delarochaf.tablasygeo.ui.theme.TablasygeoTheme
import kotlinx.coroutines.delay
import java.lang.Float

@Composable
fun Splash_Screen(navController : NavController){
    TablasygeoTheme() {
        simpleSplashScreen()
    }
}

//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun splashScreenPreview(){
    simpleSplashScreen()
}

@Composable
fun simpleSplashScreen(){
    var showPermissionsReqScreen by rememberSaveable{ mutableStateOf(false)}
    var showSplashScreen by rememberSaveable { mutableStateOf(true)}

    LaunchedEffect(showSplashScreen){
        delay(3500)
        showPermissionsReqScreen = true
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imgresource : Painter = painterResource(id = R.drawable.logotabygeotemporal)
        if(!showPermissionsReqScreen){
            Image(
                painter = imgresource, contentDescription = "LogoApp",
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
            )
        }else{

        }

    }
}

@Composable
fun PermissionRequestScreen(){
    Column() {

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PermissionDescription(){
    val imgInternetPermission : Painter = painterResource(id = R.drawable.ic_internet_permission_light)
    val imgLocationPermission : Painter = painterResource(id = R.drawable.ic_location_permission_light)
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = imgInternetPermission,
                contentDescription = "internet permission",
                modifier = Modifier.width(50.dp).height(50.dp)

            )
            Text(
                text = "Internet Permission",
                fontSize = 20.sp
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = imgLocationPermission,
                contentDescription = "internet permission"
            )
            Text(text = "Location Permission")
        }
    }
}
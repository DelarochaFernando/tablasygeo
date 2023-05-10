package com.delarochaf.tablasygeo.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.delarochaf.tablasygeo.R
import com.delarochaf.tablasygeo.ui.theme.TablasygeoTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import kotlinx.coroutines.delay

@Composable
fun Splash_Screen(navController : NavController){
    TablasygeoTheme() {
        simpleSplashScreen(navController)
    }
}

//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun splashScreenPreview(){
    //simpleSplashScreen(navController = nav)
}

@Composable
fun simpleSplashScreen(navController: NavController){
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
            PermissionRequestScreen(permissionGranted = {
                if(it){
                    navController.navigate("menuprincipal")
                }
            })
        }

    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionRequestScreen(permissionGranted: (Boolean) -> Unit){
    val imgInternetPermission : Painter = painterResource(id = R.drawable.ic_internet_permission_light)
    val imgLocationPermission : Painter = painterResource(id = R.drawable.ic_location_permission_light)
    var isPermissionGranted by rememberSaveable() { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = "Los Siguientes permisos son muy importantes para el funcionamiento" +
                    " correcto de la app.", modifier = Modifier.padding(16.dp))
        }
        /*Row(modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 12.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = imgInternetPermission,
                contentDescription = "internet permission",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)

            )
            Text(
                text = "Internet Permission",
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(20.dp, 0.dp)
            )
        }*/
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = imgLocationPermission,
                contentDescription = "internet permission",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
            )
            Text(text = "Location Permission",fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(20.dp, 0.dp)
            )
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 12.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            val permissionsState = rememberMultiplePermissionsState(
                listOf(
                    android.Manifest.permission.ACCESS_COARSE_LOCATION,
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                )
            )
            MultiplePermissionsRequired(
                multiplePermissionsState = permissionsState,
            ) {
                permissionGranted(it)
            }

            Button(onClick = {permissionsState.launchMultiplePermissionRequest()},

                ) {
                Icon(imageVector = Icons.Filled.Check, contentDescription = null)
                Text(text = "Permitir",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(8.dp, 0.dp)
                )
            }

        }
    }
}


@OptIn(ExperimentalPermissionsApi::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PermissionRequestScreenPreview(){
    val imgInternetPermission : Painter = painterResource(id = R.drawable.ic_internet_permission_light)
    val imgLocationPermission : Painter = painterResource(id = R.drawable.ic_location_permission_light)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = stringResource(id = R.string.permission_request_text1),
                modifier = Modifier.padding(16.dp)
            )
        }
        /*Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 4.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Image(
                    painter = imgInternetPermission,
                    contentDescription = "internet permission",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)

                )
                Text(
                    text = stringResource(id = R.string.permission_request_text2),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(20.dp, 0.dp)
                )
            }
            Text(text = stringResource(id = R.string.permission_request_text3),
                modifier = Modifier.padding(16.dp,0.dp),
                textAlign = TextAlign.Center,
                fontSize = 12.sp
            )
        }*/

        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 4.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = imgLocationPermission,
                    contentDescription = stringResource(id = R.string.permission_request_text4),
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                )
                Text(text = stringResource(id = R.string.permission_request_text4),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(20.dp, 0.dp)
                )
            }
            Text(text = stringResource(id = R.string.permission_request_text5),
                modifier = Modifier.padding(16.dp,0.dp),
                textAlign = TextAlign.Center,
                fontSize = 12.sp
            )
        }


        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 12.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            Button(onClick = {},

            ) {
                Icon(imageVector = Icons.Filled.Check,
                    contentDescription = stringResource(id = R.string.permission_request_text6)
                )
                Text(text = stringResource(id = R.string.permission_request_text6),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(8.dp, 0.dp)
                )
            }

        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MultiplePermissionsRequired(
    multiplePermissionsState: MultiplePermissionsState,
    permissionGranted: (Boolean) -> Unit
){
    if(multiplePermissionsState.allPermissionsGranted){
        permissionGranted(true)
    }else{
        permissionGranted(false)
    }
}
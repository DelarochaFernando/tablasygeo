package com.delarochaf.tablasygeo.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.delarochaf.tablasygeo.menuprincipal.launchMenuPrincipalActivity
import com.delarochaf.tablasygeo.navigation.NavigationHost
import com.delarochaf.tablasygeo.splashscreen.PermissionRequestScreen
import com.delarochaf.tablasygeo.splashscreen.simpleSplashScreen
import com.delarochaf.tablasygeo.ui.theme.TablasygeoTheme
import com.delarochaf.tablasygeo.windowsize.rememberWindowSizeClass



class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //WindowCompat.setDecorFitsSystemWindows(window, false)
            val windowSize = rememberWindowSizeClass()
//            TablasygeoTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    val navController = rememberNavController()
//                    navController.enableOnBackPressed(false)
//                    NavigationHost(navController = navController, windowSize = windowSize)
//                }
//            }
            Surface(
                modifier = Modifier.fillMaxSize()

            ) {
                val navController = rememberNavController()
                navController.enableOnBackPressed(false)
                //NavigationHost(navController = navController, windowSize = windowSize)

                MainScreen(navigationController = navController, permissionGranted = {
                    if(it){
                        launchMenuPrincipalActivity(context = this,navController)
                    }
                })
            }
            //this.window.statusBarColor = resources.getColor(R.color.white)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TablasygeoTheme {
        Greeting("Android")
    }
}

@Composable
fun MainScreen(navigationController: NavHostController,permissionGranted:(Boolean) -> Unit ){
    Surface() {

        //var showLandingScreen by rememberSaveable { mutableStateOf(true)}

        //if (showLandingScreen) {
            //simpleSplashScreen(navigationController, onTimeOut = { showLandingScreen = false })
        //} else {
            var showPermissionScreen by rememberSaveable{ mutableStateOf(true) }

            if (showPermissionScreen){
                PermissionRequestScreen(permissionGranted = {
                    permissionGranted(it)
                    showPermissionScreen = !it
                })
            }else{
                launchMenuPrincipalActivity(navigationController.context,navigationController)
            }
        }
    }

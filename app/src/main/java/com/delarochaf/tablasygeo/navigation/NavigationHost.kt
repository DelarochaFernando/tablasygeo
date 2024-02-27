package com.delarochaf.tablasygeo.navigation

import android.window.SplashScreen
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.delarochaf.tablasygeo.main.MainScreen
import com.delarochaf.tablasygeo.menuprincipal.MenuPrincipal
import com.delarochaf.tablasygeo.menuprincipal.launchMenuPrincipalActivity
import com.delarochaf.tablasygeo.splashscreen.Splash_Screen
import com.delarochaf.tablasygeo.windowsize.WindowSize

@Composable
fun NavigationHost(navController:NavController, windowSize: WindowSize){
    NavHost(
        navController = navController as NavHostController,
        startDestination = "mainScreen"
    ){
        composable("splashScreen"){
            Splash_Screen(navController)
        }

        composable("mainScreen"){
            MainScreen(navigationController = navController, permissionGranted = {
                launchMenuPrincipalActivity(context = navController.context,navController)
            })
        }

        composable("menuPrincipal"){
            MenuPrincipal(navController,windowSize)
        }
    }
}
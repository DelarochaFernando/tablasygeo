package com.delarochaf.tablasygeo.navigation

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.delarochaf.tablasygeo.splashscreen.Splash_Screen

@Composable
fun NavigationHost(navController:NavController){

    NavHost(navController = navController as NavHostController,
    startDestination = "splashScreen"){
        composable("splashScreen"){
            Splash_Screen(navController)
        }
    }
}
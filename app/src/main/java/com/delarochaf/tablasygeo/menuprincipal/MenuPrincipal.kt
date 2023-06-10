package com.delarochaf.tablasygeo.menuprincipal

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toBitmap
import androidx.navigation.NavController
import com.delarochaf.tablasygeo.R
import com.delarochaf.tablasygeo.ui.theme.TablasygeoTheme

@Composable
fun MenuPrincipal(navController: NavController){
    TablasygeoTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.green_chalkboard)
        ){
            MenuJuego(navController)
        }

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
    ) {
        Text(
            text = "Juegos",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(12.dp, 50.dp),
            color = Color.White,
            fontSize = 40.sp
        )
/*        CardGameOptionHorizontal(
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
        )*/
        CardWithImageAndText(imageResId = R.drawable.menu_math_kids_logo1, title = "Matemáticas", description = "math")
        Spacer(modifier = Modifier.height(24.dp))
        CardWithImageAndText(imageResId = R.drawable.menu_geography_kids_logo1, title = "Geografía", description = "geo")
    }

    val activity = LocalContext.current as Activity
    activity.window.statusBarColor = LocalContext.current.resources.getColor(R.color.green_chalkboard)
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
                    .size(45.dp)

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
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.size(205.dp,100.dp)
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

@Composable
fun CardWithImageAndText(imageResId: Int, title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 100.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            val resources = LocalContext.current.resources
            val bitmap by rememberSaveable{
                mutableStateOf(BitmapFactory
                    .decodeResource(resources,imageResId))
            }
            Image(
                //painter = painterResource(id = imageResId),
                //painter = painterResource(id = imageResId),
                bitmap = bitmap!!.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .height(160.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.body1,
                color = Color.Gray
            )
        }
    }
}


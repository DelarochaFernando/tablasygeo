package com.delarochaf.tablasygeo.subcategoriajuego

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.delarochaf.tablasygeo.menuprincipal.MenuJuego
import com.delarochaf.tablasygeo.menuprincipal.MenuPrincipalActivity
import dagger.hilt.android.AndroidEntryPoint


fun launchSubCategoriaJuegoActivity(context: Context,
                                navController: NavController,
                                    idSubCat : Int
){

    var intent = Intent(context, SubCategoriaJuegoActivity::class.java)
    val bundle = Bundle()
    intent.putExtra("idSubCategoria",idSubCat)
    context.startActivity(intent)
}

@AndroidEntryPoint
class SubCategoriaJuegoActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val idSubCat = intent.extras?.get("idSubCategoria")
        setContent {

            when(idSubCat){
                0 -> SubCategoriaScreen("Matemáticas")
                1 -> SubCategoriaScreen("Geografía")
                else ->{

                }
            }

        }
    }
}

@Composable
fun SubCategoriaScreen(subcategoria : String){
    Surface(color = Color(0xFF1B5E20)) {

        var text = "";
        Column(modifier = Modifier.fillMaxSize()) {
            if (subcategoria.equals("Matemáticas")){
                text = "Aprende a:"
            }else if (subcategoria.equals("Geografía")){
                text = "Aprende sobre la "+ subcategoria+" de tu país."
            }
            Text(
                text = text,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(12.dp, 40.dp),
                color = Color.White,
                fontSize = 40.sp
            )
        }
    }
}
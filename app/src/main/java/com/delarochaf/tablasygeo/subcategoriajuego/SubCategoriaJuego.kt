package com.delarochaf.tablasygeo.subcategoriajuego

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
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

        var text = ""
        var idSubCat = 0
        Column(modifier = Modifier.fillMaxSize()) {
            if (subcategoria.equals("Matemáticas")){
                text = "Aprende a:"
                idSubCat = 0
            }else if (subcategoria.equals("Geografía")){
                text = "Aprende sobre la "+ subcategoria+" de tu país."
                idSubCat = 1
            }
            Text(
                text = text,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(12.dp, 40.dp),
                color = Color.White,
                fontSize = 40.sp
            )
            Spacer(modifier = Modifier.height(24.dp))
            when(idSubCat){
                0-> SubCategoriaMatematicasContent()
                1 -> SubCategoriaGeografiaContent()
            }
        }
    }
}

@Composable
fun SubCategoriaMatematicasContent(){
    //LazyColumn(content = )
}
@Composable
fun SubCategoriaGeografiaContent(){

}


@Composable
@Preview
fun MatematicasItemPreview(){
    Card(
        shape = RoundedCornerShape(4.dp),
        elevation = 4.dp
    ) {
        Column() {
            Image(painter = , contentDescription = )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Sumar",
                style = MaterialTheme.typography.h6,
                color = Color.Black
            )
        }
    }
}

@Composable
fun DisplayImageAndText(imageBitmap: ImageBitmap, operation: String) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Gray // Fondo gris para visualizar mejor el pizarrón
    ) {
        // Utilizar Canvas para dibujar la imagen generada y agregar texto
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White) // Fondo blanco para el pizarrón
        ) {
            drawImage(image = imageBitmap)

            // Agregar texto en el pizarrón
            /*drawContext.canvas.nativeCanvas.drawText(
                operation,
                size.width / 4,
                size.height / 1.5f,
                //textPaint
            )*/
        }
    }
}

@Composable
@Preview
fun PreviewDisplayImageAndText(){

}
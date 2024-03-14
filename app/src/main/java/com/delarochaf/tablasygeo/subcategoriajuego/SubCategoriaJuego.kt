package com.delarochaf.tablasygeo.subcategoriajuego

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.delarochaf.tablasygeo.R
import com.delarochaf.tablasygeo.imagegenerator.ImageGenerator
import com.delarochaf.tablasygeo.menuprincipal.MenuJuego
import com.delarochaf.tablasygeo.menuprincipal.MenuPrincipalActivity
import com.delarochaf.tablasygeo.ui.theme.chalkboardGreen
import dagger.hilt.android.AndroidEntryPoint


fun launchSubCategoriaJuegoActivity(context: Context,
                                navController: NavController,
                                    idSubCat : Int
){

    var intent = Intent(context, SubCategoriaJuegoActivity::class.java)
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
                    .padding(0.dp,30.dp),
                color = Color.White,
                fontSize = 60.sp
            )
            when(idSubCat){
                0-> SubCategoriaMatematicasContent(modifier = Modifier)
                1 -> SubCategoriaGeografiaContent()
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SubCategoriaMatematicasContent(modifier: Modifier,
 viewModel: SubCategoriaJuegoViewModel = SubCategoriaJuegoViewModel(
 LocalContext.current),lazygridstate : LazyGridState =  rememberLazyGridState()
){

    //viewModel.creatListOfMatematicasItems()
    val listItemsMathContent by viewModel.listItemsMathContent.collectAsStateWithLifecycle()

ConstraintLayout(modifier = Modifier.fillMaxSize()) {
    val lazyCol = createRef()
    LazyColumn(
        modifier = Modifier
            .constrainAs(lazyCol,{
                top.linkTo(parent.top, margin = 40.dp)
            })
            .fillMaxSize()
            .padding(200.dp, 0.dp),
        //verticalArrangement = Arrangement.Center,
        state = rememberLazyListState()
    ){
        items(listItemsMathContent){MathContentItem ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize()
                    .background(Color.Yellow),
                contentAlignment = Alignment.Center
            ) {
                MatematicasItem(modifier = modifier, subCatJuegoModel = MathContentItem)
            }
        }
    }
}

    /*LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.padding(8.dp)
        ){
        items(listItemsMathContent){MathContentItem ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize()
                    .background(Color.Yellow),
                contentAlignment = Alignment.Center
            ) {
                MatematicasItem(modifier = modifier, subCatJuegoModel = MathContentItem)
            }
        }
    }*/
}
@Composable
fun SubCategoriaGeografiaContent(){

}


@Composable
fun MatematicasItem(modifier : Modifier, subCatJuegoModel: SubCatJuegoModel){
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp),
        shape = RoundedCornerShape(4.dp),
        elevation = 4.dp,
        backgroundColor = Color(LocalContext.current.resources.getColor(R.color.green_chalkboard))
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Image(bitmap = subCatJuegoModel.bitmap.asImageBitmap(),
                contentDescription = subCatJuegoModel.nombreOperacion
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = subCatJuegoModel.nombreOperacion,
                style = MaterialTheme.typography.h6,
                color = Color.White
            )
        }
    }
}

@Composable
@Preview
fun MatematicasItemPreview(){
    Card(
        shape = RoundedCornerShape(4.dp),
        elevation = 4.dp
    ) {
        Column() {
            //Image(bitmap = , contentDescription = )
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
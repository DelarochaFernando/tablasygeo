package com.delarochaf.tablasygeo.subcategoriajuego

import android.content.Context
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.delarochaf.tablasygeo.di.DefaultDispatcher
import com.delarochaf.tablasygeo.imagegenerator.ImageGenerator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SubCategoriaJuegoViewModel(
    context: Context
) : ViewModel() {

    val context = context

    private val _listItemsMathContent = MutableStateFlow<List<SubCatJuegoModel>>(emptyList())
    val listItemsMathContent : StateFlow<List<SubCatJuegoModel>> =
        _listItemsMathContent.asStateFlow()

    init {
        creatListOfMatematicasItems()
    }


    @NoLiveLiterals
    fun creatListOfMatematicasItems(){


        var listOperaciones = listOf("2 + 3 = 5","8 - 4 = 4","5 x 4 = 20","10 ÷ 5 = 2")
        var listNombreOperaciones = listOf("Sumar","Restar","Multiplicar","Dividir")
        var listOfSubCatModel = emptyList<SubCatJuegoModel>().toMutableList()
        val subcatlistIterator = listOfSubCatModel.listIterator()
        //var listOfSubCatModel = mutableListOf<SubCatJuegoModel>(emptyList<SubCatJuegoModel>())
        var count = 0
        for ((index,operacion) in listOperaciones.withIndex()){
            val generatedBitmap = ImageGenerator.generateTizaImage(context,operacion.toString())
            subcatlistIterator.add(SubCatJuegoModel(listNombreOperaciones.get(index),generatedBitmap))
            //listOfSubCatModel[index] =
                //SubCatJuegoModel(listNombreOperaciones.get(index),generatedBitmap)
            count++
        }
        _listItemsMathContent.value = listOfSubCatModel
    }


}
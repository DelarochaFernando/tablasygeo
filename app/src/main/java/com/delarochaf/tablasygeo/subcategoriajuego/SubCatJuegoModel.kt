package com.delarochaf.tablasygeo.subcategoriajuego

import android.graphics.Bitmap
import javax.annotation.concurrent.Immutable

@Immutable
data class SubCatJuegoModel(
    val nombreOperacion : String,
    val bitmap: Bitmap
)
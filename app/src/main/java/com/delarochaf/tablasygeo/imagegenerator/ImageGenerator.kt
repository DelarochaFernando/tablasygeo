package com.delarochaf.tablasygeo.imagegenerator

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.core.content.ContextCompat
import com.delarochaf.tablasygeo.R

object ImageGenerator {

    fun generateTizaImage(context: Context, operationString: String):Bitmap {
        // Tamaño de la imagen
        val width = 600
        val height = 300

        // Crear un Bitmap y un lienzo
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        // Fondo transparente
        canvas.drawColor(Color.TRANSPARENT)

        // Pintar el fondo del pizarrón
        val pizarraPaint = Paint().apply {
            color = ContextCompat.getColor(context, R.color.green_chalkboard)
        }
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), pizarraPaint)

        // Pintar el texto de la operación matemática
        val textoPaint = Paint().apply {
            color = Color.WHITE
            textSize = 65f
        }
        canvas.drawText(operationString, 170f, 200f, textoPaint)


        return bitmap
    }
}
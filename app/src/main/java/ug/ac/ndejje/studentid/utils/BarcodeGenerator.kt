package ug.ac.ndejje.studentid.utils

import android.graphics.Bitmap
import android.graphics.Color
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter

object BarcodeGenerator{

    fun generateBarcode(text: String, width: Int, height: Int) : Bitmap{
        val bitMatrix = MultiFormatWriter().encode(
            text,
            BarcodeFormat.CODE_128,
            width,
            height
        )
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)

        for(x in 0 until width){
            for(y in 0 until height){
                bitmap.setPixel(
                    x,
                    y,
                    if(bitMatrix[x,y]) Color.BLACK else Color.WHITE
                )
            }
        }
        return bitmap
    }
}
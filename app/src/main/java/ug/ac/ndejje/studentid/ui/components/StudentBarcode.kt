package ug.ac.ndejje.studentid.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ug.ac.ndejje.studentid.utils.BarcodeGenerator

@Composable
fun StudentBarcode(studentId: String){
    // Generate barcode bitmap once

    val barcodeBitmap = remember(studentId){
        BarcodeGenerator.generateBarcode(studentId,920,80)
    }

    Column(
        modifier= Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(2.dp))

        //Display barcode
        Image(
            bitmap = barcodeBitmap.asImageBitmap(),
            contentDescription = "Barcode",
            modifier = Modifier
                .fillMaxWidth(0.90f)
                .height(20.dp)
        )
    }

}
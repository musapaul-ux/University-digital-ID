package ug.ac.ndejje.studentid.ui.screens



import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.R
import ug.ac.ndejje.studentid.ui.components.StudentBarcode

@Composable
fun IDCardScreen(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        StudentBarcode(studentId = "24/1/306/D/455")
    }
}
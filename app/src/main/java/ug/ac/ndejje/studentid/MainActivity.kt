package ug.ac.ndejje.studentid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ug.ac.ndejje.studentid.ui.theme.StudentIDTheme
import java.nio.file.Files.size

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    UniversityDigitalIDCard()
                }
            }
        }
    }
}

@Composable
fun UniversityDigitalIDCard() {

    ElevatedCard(
        modifier = Modifier
            .width(360.dp)
            .height(250.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.elevatedCardElevation(8.dp)
    ) {

        Box {

            // WATERMARK BACKGROUND
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.07f),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ndu_logo),
                    contentDescription = null,
                    modifier = Modifier.size(140.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.ndu_logo),
                    contentDescription = null,
                    modifier = Modifier.size(140.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // MAROON HEADER
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .background(Color(0xFF8B1E1E))
                )

                Spacer(modifier = Modifier.height(45.dp))

                // STUDENT NAME
                Text(
                    text = "VIOLA JOAN",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                // PROGRAMME
                Text(
                    text = "Programme: BSc Computer Science",
                    fontSize = 13.sp
                )

                // REGISTRATION NUMBER
                Row {
                    Text(
                        text = "Registration Number: ",
                        fontSize = 13.sp
                    )
                    Text(
                        text = "24/U/1234",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                    )
                }

                // DATES
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row {
                        Text(
                            text = "Date of Issue: ",
                            fontSize = 12.sp
                        )
                        Text(
                            text = "01/02/2026",
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                    }

                    Row {
                        Text(
                            text = "Expiry Date: ",
                            fontSize = 12.sp
                        )
                        Text(
                            text = "01/02/2029",
                            fontSize = 12.sp
                        )
                    }
                }

                // FOOTER (BARCODE + STRIP)
                IDCardFooter()
            }

            // LOGOS ROW (extends slightly below header)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .offset(y = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ndu_logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(85.dp)
                        .clip(CircleShape)
                )

                Image(
                    painter = painterResource(id = R.drawable.ug_flag),
                    contentDescription = "Flag",
                    modifier = Modifier.size(65.dp)
                )
            }

            // PROFILE PHOTO
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = 15.dp),
                contentAlignment = Alignment.TopCenter
            ) {

                Image(
                    painter = painterResource(id = R.drawable.student_photo),
                    contentDescription = "Student Photo",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(4.dp, Color(0xFF8B1E1E), CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
fun IDCardFooter() {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .padding(horizontal = 12.dp)
        ) {

            val barWidth = size.width / 90

            for (i in 10..80) {

                if (i % 2 == 0) {

                    drawRect(
                        color = Color.Black,
                        topLeft = Offset(i * barWidth, 0f),
                        size = Size(barWidth, size.height)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .background(Color(0xFF8B1E1E))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun IDPreview() {
    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            UniversityDigitalIDCard()
        }
    }
}
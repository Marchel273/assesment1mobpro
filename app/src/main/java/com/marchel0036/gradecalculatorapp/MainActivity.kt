package com.marchel0036.gradecalculatorapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marchel0036.gradecalculatorapp.ui.theme.GradeCalculatorAppTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip


val Montserrat = FontFamily(
    Font(R.font.montserrat_regular, FontWeight.Normal)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GradeCalculatorAppTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.titleLarge,
                        fontFamily = Montserrat
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6C63FF),
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        ScreenContent(Modifier.padding(innerPadding))
    }
}

@Composable
fun ScreenContent(modifier: Modifier = Modifier) {

    var tugas by remember { mutableStateOf("") }
    var uts by remember { mutableStateOf("") }
    var uas by remember { mutableStateOf("") }
    var hasil by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_grade),
            contentDescription = "Grade Image",
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .align(Alignment.CenterHorizontally)
                .clip(RoundedCornerShape(12.dp))
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = tugas,
            onValueChange = { tugas = it },
            label = { Text("Nilai Tugas") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = uts,
            onValueChange = { uts = it },
            label = { Text("Nilai UTS") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = uas,
            onValueChange = { uas = it },
            label = { Text("Nilai UAS") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {

                if (tugas.isNotEmpty() && uts.isNotEmpty() && uas.isNotEmpty()) {

                    val t = tugas.toDouble()
                    val u = uts.toDouble()
                    val a = uas.toDouble()

                    val final = 0.3 * t + 0.3 * u + 0.4 * a

                    val grade = when {
                        final >= 85 -> "A"
                        final >= 70 -> "B"
                        final >= 60 -> "C"
                        final >= 50 -> "D"
                        else -> "E"
                    }

                    hasil = "Nilai: ${"%.2f".format(final)} (Grade $grade)"
                } else {
                    hasil = "Input tidak boleh kosong"
                }

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Hitung Nilai")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = hasil,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun MainScreenPreview() {
    GradeCalculatorAppTheme {
        MainScreen()
    }
}
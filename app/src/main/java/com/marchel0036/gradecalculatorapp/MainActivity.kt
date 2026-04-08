package com.marchel0036.gradecalculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.marchel0036.gradecalculatorapp.navigation.SetupNavGraph
import com.marchel0036.gradecalculatorapp.ui.theme.GradeCalculatorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GradeCalculatorAppTheme {
                SetupNavGraph()
            }
        }
    }
}
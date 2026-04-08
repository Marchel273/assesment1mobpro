package com.marchel0036.gradecalculatorapp.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.marchel0036.gradecalculatorapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.tentang_aplikasi)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack, // 🔥 FIX (anti crash)
                            contentDescription = stringResource(R.string.kembali)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->

        Text(
            text = stringResource(R.string.copyright),
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
package com.campusresolve.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.campusresolve.app.ui.navigation.AppNavigation
import com.campusresolve.app.ui.theme.CampusResolveTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            CampusResolveTheme {
                AppNavigation()
            }
        }
    }
}
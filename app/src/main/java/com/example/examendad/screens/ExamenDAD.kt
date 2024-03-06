package com.example.examendad.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class ExamenDAD() {
    Login,
    PantallaCards,
}


@Composable
fun MyApp(navController: NavHostController = rememberNavController()){
    Scaffold() {
            innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ExamenDAD.Login.name,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ){
            composable(route = ExamenDAD.Login.name){
                Logueo(onSendButtonClicked = {
                    navController.navigate(ExamenDAD.PantallaCards.name)
                })
            }
            composable(route = ExamenDAD.PantallaCards.name) {
                Text("Pantalla Cards")
            }
        }
    }
    Logueo(onSendButtonClicked = { navController.navigate(ExamenDAD.PantallaCards.name) })
}




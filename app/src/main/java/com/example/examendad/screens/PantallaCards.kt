package com.example.examendad.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.examendad.R

@Composable
fun PantallaCards (){
    MiTopBar()
}




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiTopBar() {
    Box(modifier = Modifier.fillMaxSize()){
        Column (modifier = Modifier.fillMaxSize()) {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                title = {
                    Text("Material 3")
                    Column (modifier = Modifier.padding(start = 325.dp)){
                        Row (){
                            Icon(painter = painterResource(id = R.drawable.baseline_brush_24), contentDescription = "Search")
                            Icon(painter = painterResource(id = R.drawable.baseline_apps_24), contentDescription = "More")
                        }
                    }
                }
            )
            Spacer(modifier = Modifier.height(5.dp))
            LazyColumn(
                modifier = Modifier.padding(start = 70.dp, top = 30.dp),
                verticalArrangement = (Arrangement.Center),
                horizontalAlignment = (Alignment.CenterHorizontally)
            ) {
                val items = List(3) { }
                items (items.size){
                    cadaItem ->
                    FilledCardExample()
                    Spacer(modifier = Modifier.height(80.dp))
                }
            }
        }
    }
}


@Composable
fun FilledCardExample() {
    var numero: Int = 0
    var showBottomSheet by remember { mutableStateOf(false) }
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier.size(width = 240.dp, height = 100.dp)
    ){
        Row {
        Text(text = "Imagen ${numero +1}", modifier = Modifier.weight(1f))
        IconButton(onClick = {

        }){
            Icon(painter = painterResource(id = R.drawable.baseline_apps_24), contentDescription = "More")
        }
        }
    }
}

@Composable
fun BottomSheetContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Mensaje")
    }
}


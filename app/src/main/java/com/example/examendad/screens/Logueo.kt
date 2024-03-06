package com.example.examendad.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.examendad.R

@Composable
fun Logueo(onSendButtonClicked: () -> Unit){

    var showError by remember { mutableStateOf(true) }
    var user by remember { mutableStateOf(TextFieldValue("")) }
    var password by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo")
        Text("Usuario", color = MaterialTheme.colorScheme.secondary)
        OutLineTextFieldUser()
        OutLineTextFieldPassword()
        Column {
            Button(onClick = {
                if (user.text.isEmpty() ||password.isEmpty()){
                    showError = true
                } else {
                    showError = false
                    onSendButtonClicked()
                }
            }) {
                Text(text = "Enabled")
            }
        }
        if (showError) {
            Text("Por favor, completa todos los campos.", color = Color.Red)
        }
    }
}


@Composable
fun OutLineTextFieldUser() {
    var user = remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        modifier = Modifier.padding(vertical = 10.dp),
        value = user.value,
        label = { Text(text = "Introduce tu usuario") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = {
            user.value = it
        }
    )
}

@Composable
fun OutLineTextFieldPassword() {
    var password = rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = password.value,
        onValueChange = { password.value = it },
        label = { Text(text = "Introduce tu contraseña") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}
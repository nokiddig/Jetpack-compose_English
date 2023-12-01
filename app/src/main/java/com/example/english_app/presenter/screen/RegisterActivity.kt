package com.example.english_app.presenter.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.english_app.R
import com.example.english_app.ui.theme.English_appTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            English_appTheme {
                LoginSurface(modifier = Modifier.fillMaxSize())
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LoginSurface(modifier: Modifier) {
        var username by rememberSaveable() {
            mutableStateOf("")
        }
        var fullName by rememberSaveable() {
            mutableStateOf("")
        }
        var schoolName by rememberSaveable() {
            mutableStateOf("")
        }
        var password by rememberSaveable() {
            mutableStateOf("")
        }
        var age by rememberSaveable() {
            mutableStateOf(18)
        }

        Box(
            modifier = modifier.paint(
                painterResource(id = R.drawable.register),
                contentScale = ContentScale.FillBounds
            )
        )

        Column {
            OutlinedTextField(value = username, onValueChange = {
                username = it
            }, textStyle = TextStyle(color = Color.Black),
                modifier = Modifier
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .width(300.dp),
                placeholder = { Text(text = "Input username...") }
            )

            OutlinedTextField(value = password, onValueChange = {
                password = it
            }, textStyle = TextStyle(color = Color.Black),
                modifier = Modifier
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .width(300.dp),
                placeholder = { Text(text = "Input pass...") },
                visualTransformation = PasswordVisualTransformation()
            )

            Button(onClick = { /*TODO*/ }) {
                Row {
                    Text(text = "Submit")
                    Icon(imageVector = Icons.Outlined.KeyboardArrowRight, contentDescription = "")
                }
            }
        }
    }

}
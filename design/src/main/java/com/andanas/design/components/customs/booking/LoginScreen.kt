package com.andanas.design.components.customs.booking

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andanas.design.R
import com.andanas.design.ui.theme.SuperAppExampleTheme

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var keepSignedIn by remember { mutableStateOf(true) }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Login", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(4.dp))
        Text("Welcome back to the app", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(24.dp))

        var tabSelected by remember { mutableStateOf(0) }
        TabRow(selectedTabIndex = tabSelected) {
            Tab(selected = tabSelected == 0, onClick = { tabSelected = 0 }) {
                Text(
                    "Email",
                    modifier = Modifier.padding(16.dp),
                    color = if (tabSelected == 0) Color.Red else Color.Gray
                )
            }
            Tab(selected = tabSelected == 1, onClick = { tabSelected = 1 }) {
                Text(
                    "Phone Number",
                    modifier = Modifier.padding(16.dp),
                    color = if (tabSelected == 1) Color.Red else Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email Address") },
            placeholder = { Text("hello@example.com") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
//                    Icon(
//                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
//                        contentDescription = null
//                    )
                }
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
        )

        Text(
            text = "Forgot Password?",
            color = Color.Red,
            modifier = Modifier
                .align(Alignment.End)
                .clickable { /* handle click */ }
                .padding(top = 4.dp, bottom = 16.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = keepSignedIn,
                onCheckedChange = { keepSignedIn = it },
                colors = CheckboxDefaults.colors(checkedColor = Color.Red)
            )
            Text("Keep me signed in")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* login action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login", color = Color.White)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(modifier = Modifier.weight(1f))
            Text(" or sign in with ", modifier = Modifier.padding(horizontal = 8.dp))
            Divider(modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = { /* Google sign in */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(painterResource(id = R.drawable.ic_inventory_app), contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Continue with Google")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            "Create an account",
            color = Color.Red,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable { /* go to register */ }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    SuperAppExampleTheme {
        LoginScreen()
    }
}
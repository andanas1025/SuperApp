package com.andanas.design.components.customs.inventory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andanas.design.ui.theme.SuperAppExampleTheme

@Composable
fun AddProductScreen(
    onSave: (Product) -> Unit,
    onCancel: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var code by remember { mutableStateOf("") }
    var stockText by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }

    var nameError by remember { mutableStateOf(false) }
    var stockError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text("Add New Product", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
                nameError = false
            },
            label = { Text("Product Name") },
            isError = nameError,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description (optional)") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = code,
            onValueChange = { code = it },
            label = { Text("Code or SKU") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = stockText,
            onValueChange = {
                stockText = it
                stockError = false
            },
            label = { Text("Initial Stock") },
            isError = stockError,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = category,
            onValueChange = { category = it },
            label = { Text("Category (optional)") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            label = { Text("Location (optional)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = onCancel) {
                Text("Cancel")
            }

            Button(onClick = {
                val stock = stockText.toIntOrNull()
                val isValid = name.isNotBlank() && stock != null

                nameError = name.isBlank()
                stockError = stock == null

                if (isValid) {
                    val product = Product(
                        name = name,
                        description = description,
                        code = code,
                        stock = stock!!,
                        category = category,
                        location = location
                    )
                    onSave(product)
                }
            }) {
                Text("Save")
            }
        }
    }
}

@Composable
@Preview
fun AddProductScreenPreview() {
    SuperAppExampleTheme {
        AddProductScreen({}, {})
    }
}
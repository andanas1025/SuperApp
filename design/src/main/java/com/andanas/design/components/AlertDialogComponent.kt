package com.andanas.design.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AlertDialogComponent(
    errorTitle: String = "An error has occurred",
    errorText: String = "Something went wrong",
    textButtonRetry: String = "retry",
    onRetry: () -> Unit
) {
    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = errorTitle) },
        text = { Text(text = errorText) },
        confirmButton = {
            TextButton(onClick = onRetry) {
                Text(textButtonRetry)
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
fun AlertDialogComponentPreview() {
    AlertDialogComponent(
        errorTitle = "Error",
        errorText = "Something went wrong",
        textButtonRetry = "Retry",
        onRetry = {}
    )
}
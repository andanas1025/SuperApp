package com.globant.superappexample.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.globant.superappexample.R
import com.globant.superappexample.presentation.ui.theme.SuperAppExampleTheme

@Composable
fun AppToolbar(innerPadding: PaddingValues) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(innerPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = R.drawable.ic_inventory_app),
            contentDescription = "Icon image"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppToolbarPreview() {
    SuperAppExampleTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            AppToolbar(innerPadding)
        }
    }
}
package com.globant.superappexample.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.globant.superappexample.R

@Composable
fun AppToolbar(innerPadding: PaddingValues) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(innerPadding)
    ) {
        Icon(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = R.drawable.ic_inventory_app),
            contentDescription = "Icon image"
        )
    }
}
package com.globant.superappexample.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

@Composable
private fun MainSpace(size: Dp) {
    Spacer(modifier = Modifier.width(size))
}

@Composable
fun SpaceWidth() {
    MainSpace(18.dp)
}
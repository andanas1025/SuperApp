package com.globant.superappexample.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.globant.superappexample.presentation.ui.theme.blackColor

@Composable
fun TextComponent(
    textValue: String,
    textColorValue: Color = blackColor,
    fontSizeValue: TextUnit = 16.sp,
    modifier: Modifier,
    paddingValue: Dp = 0.dp
) {
    Text(
        modifier = modifier
            .padding(all = paddingValue),
        text = textValue,
        style = TextStyle(
            color = textColorValue,
            fontSize = fontSizeValue
        ),
        textAlign = TextAlign.Center
    )
}
package com.globant.superappexample.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun BannerComponent(
    title: String? = null,
    description: String? = null,
    image: String? = null
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .padding(12.dp)
            .background(Color.Green),
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = image,
            contentDescription = "Banner image",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            title?.let {
                TextComponent(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(8.dp),
                    textValue = title,
                    fontSizeValue = 24.sp
                )
            }

            description?.let {
                TextComponent(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(8.dp),
                    textValue = it
                )
            }
        }
    }
}

@Preview
@Composable
fun BannerComponentPreview() {
    BannerComponent(
        title = "Hello World",
        description = "description"
    )
}
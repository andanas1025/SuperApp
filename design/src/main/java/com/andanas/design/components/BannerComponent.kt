package com.andanas.design.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun BannerComponent(
    title: String? = null,
    description: String? = null,
    image: String? = null,
    resourceValue: Int? = null
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .size(240.dp)
            .padding(12.dp)
            .clip(
                shape = RoundedCornerShape(12.dp)
            ),
    ) {
        image?.let {
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = it,
                contentDescription = "Banner image",
                contentScale = ContentScale.Crop
            )
        }
        resourceValue?.let {
            ImageComponent(
                modifier = Modifier
                    .size(120.dp)
                    .padding(18.dp)
                    .align(Alignment.CenterEnd),
                resourceValue = it
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(18.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            title?.let {
                TextComponent(
                    modifier = Modifier
                        .wrapContentSize(),
                    textValue = it,
                    fontSizeValue = 24.sp,
                    paddingValue = 0.dp
                )
            }

            description?.let {
                TextComponent(
                    modifier = Modifier
                        .wrapContentSize(),
                    textValue = it,
                    paddingValue = 0.dp
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
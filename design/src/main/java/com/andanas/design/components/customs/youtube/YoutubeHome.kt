package com.andanas.design.components.customs.youtube

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun YoutubeHome() {
    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text(text = "Youtube") },
//                backgroundColor = MaterialTheme.colors.surface,
//                contentColor = MaterialTheme.colors.onSurface,
//                elevation = if (MaterialTheme.colors.isLight) 0.dp else 8.dp,
//                navigationIcon = {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_inventory_app),
//                        contentDescription = null,
//                        tint = Color.Red,
//                        modifier = Modifier.padding(start = 16.dp)
//                    )
//                },
//                actions = {
//                    Icon(
//                        imageVector = Icons.Default.Settings,
//                        contentDescription = null,
//                        modifier = Modifier.padding(horizontal = 8.dp)
//                    )
//                    Icon(
//                        imageVector = Icons.Default.Search,
//                        contentDescription = null,
//                        modifier = Modifier.padding(horizontal = 8.dp)
//                    )
//                    Image(
//                        painter = painterResource(id = R.drawable.p3),
//                        contentDescription = null,
//                        modifier = Modifier
//                            .padding(vertical = 4.dp, horizontal = 8.dp)
//                            .size(24.dp)
//                            .clip(CircleShape)
//                    )
//                }
//            )
//        },
        content = { contentPadding ->
            Surface(
//                tonalElevation = if (isLightTheme()) 0.dp else 8.dp
            ) {
                YoutubeContent(contentPadding)
            }
        }
    )
}

@Composable
fun YoutubeContent(contentPadding: PaddingValues) {
    val tweets = remember { DemoDataProvider.tweetList.filter { it.tweetImageId > 0 } }
    // There is performance issue when using LazyRowFor and LazyColumnFor inside scrollableColumn
    // So using column for now.
    Column {
        Divider()
        LazyRow(
            modifier = Modifier.padding(vertical = 8.dp),
            contentPadding = PaddingValues(horizontal = 12.dp),
        ) {
            items(
                items = tweets,
                itemContent = {
                    YoutubeChip(
                        selected = it.id == 2,
                        text = it.author,
                        modifier = Modifier.padding(
                            horizontal = 4.dp,
                        )
                    )
                }
            )
        }
        LazyColumn {
            items(
                items = tweets,
                itemContent = { item -> YoutubeListItem(item) }
            )
        }
    }
}
package com.andanas.design.components.customs.podcastDetail

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.EaseOutExpo
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.andanas.design.R

@Composable
fun PodcastDetailsHeaderItem(
    podcast: PodcastInfo,
    toggleSubscribe: (PodcastInfo) -> Unit,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier = modifier.padding(16.dp)
    ) {
        val maxImageSize = this.maxWidth / 2
        val imageSize = min(maxImageSize, 148.dp)
        Column {
            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.fillMaxWidth()
            ) {
                PodcastImage(
                    modifier = Modifier
                        .size(imageSize)
                        .clip(MaterialTheme.shapes.large),
                    podcastImageUrl = podcast.imageUrl,
                    contentDescription = podcast.title
                )
                Column(
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(
                        text = podcast.title,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.headlineMedium
                    )
                    PodcastDetailsHeaderItemButtons(
                        isSubscribed = podcast.isSubscribed ?: false,
                        onClick = {
                            toggleSubscribe(podcast)
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            PodcastDetailsDescription(
                podcast = podcast,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )
        }
    }
}

@Composable
fun PodcastDetailsDescription(
    podcast: PodcastInfo,
    modifier: Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }
    var showSeeMore by remember { mutableStateOf(false) }
    Box(
        modifier = modifier.clickable { isExpanded = !isExpanded }
    ) {
        Text(
            text = podcast.description,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = if (isExpanded) Int.MAX_VALUE else 3,
            overflow = TextOverflow.Ellipsis,
            onTextLayout = { result ->
                showSeeMore = result.hasVisualOverflow
            },
            modifier = Modifier.animateContentSize(
                animationSpec = tween(
                    durationMillis = 200,
                    easing = EaseOutExpo
                )
            )
        )
        if (showSeeMore) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .background(MaterialTheme.colorScheme.surface)
            ) {
                // TODO: Add gradient effect
                Text(
                    text = stringResource(id = R.string.add_address),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        textDecoration = TextDecoration.Underline,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PodcastDetailsHeaderItemPreview() {
    PodcastDetailsHeaderItem(
        podcast = PreviewPodcasts[0],
        toggleSubscribe = { },
    )
}
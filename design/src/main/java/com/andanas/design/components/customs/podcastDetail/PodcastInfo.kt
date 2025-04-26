package com.andanas.design.components.customs.podcastDetail

import java.time.OffsetDateTime

data class PodcastInfo(
    val uri: String = "",
    val title: String = "",
    val author: String = "",
    val imageUrl: String = "",
    val description: String = "",
    val isSubscribed: Boolean? = null,
    val lastEpisodeDate: OffsetDateTime? = null,
)
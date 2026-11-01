package com.glassa.vaultdownloader.data.model

data class MediaItem(
    val id: String,
    val uri: String,
    val displayName: String,
    val mimeType: String,
    val size: Long,
    val dateAdded: Long,
    val isFavorite: Boolean = false
)

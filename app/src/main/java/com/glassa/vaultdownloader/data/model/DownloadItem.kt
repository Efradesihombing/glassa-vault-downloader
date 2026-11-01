package com.glassa.vaultdownloader.data.model

data class DownloadItem(
    val id: String,
    val url: String,
    val fileName: String,
    val mimeType: String,
    val status: MediaStatus = MediaStatus.PENDING,
    val progress: Int = 0,
    val localUri: String? = null,
    val createdAt: Long
) {
    init {
        require(progress in 0..100) { "Progress must be between 0 and 100" }
    }
}

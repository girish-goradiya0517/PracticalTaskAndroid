package com.practical.task.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.practical.task.data.model.Element
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun BannerSection(banner: Element) {
    val imageUrl = banner.mobileImageUrl ?: banner.mediaData?.cover?.fullUrl.orEmpty()

    Box(
        modifier = Modifier.fillMaxWidth()

    ) {
        CoilImage(imageModel = { imageUrl },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            loading = {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Color.LightGray)
                )
            },
            failure = {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Image failed", color = Color.White)
                }
            })
    }
}

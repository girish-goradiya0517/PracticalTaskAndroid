package com.practical.task.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practical.task.data.model.Element
import com.skydoves.landscapist.coil.CoilImage
import java.util.Locale


@Composable
fun EditorChoiceSection(editorChoice: Element) {
    val items = editorChoice.componentItems ?: emptyList()
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val itemWidth = if (items.size == 1) screenWidth * 0.95f else screenWidth * 0.9f
    val sidePadding = (screenWidth - itemWidth) / 2

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(top = 30.dp)
    ) {
        Text(
            text = editorChoice.header.uppercase(Locale.getDefault()),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Gray,
            letterSpacing = 1.2.sp,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Text(
            text = "“${editorChoice.subheader}”",
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = sidePadding),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(items) { item ->
                Column(
                    modifier = Modifier
                        .width(itemWidth)
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    CoilImage(imageModel = { item.mediaData.cover.fullUrl },
                        modifier = Modifier
                            .height(180.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(15.dp)),
                        failure = {
                            Box(
                                Modifier
                                    .fillMaxSize()
                                    .background(Color.Gray),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("Failed to load image", color = Color.White)
                            }
                        })
                }
            }
        }
    }
}

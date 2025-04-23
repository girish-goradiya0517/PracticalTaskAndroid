package com.practical.task.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practical.task.data.model.Element
import com.practical.task.ui.theme.ButtonBorder
import com.practical.task.ui.theme.CardColor
import com.practical.task.ui.theme.FontColor
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun PopularBookCard(imageUrl: String, title: String, subtitle: String, cta: String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = CardColor),
        modifier = Modifier
            .width(240.dp)
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            CoilImage(
                imageModel = { imageUrl },
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = subtitle,
                fontSize = 13.sp,
                color = Color.Gray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedButton(
                onClick = { /* Handle action */ },
                shape = RoundedCornerShape(45),
                border = BorderStroke(1.dp, ButtonBorder),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = cta, color = FontColor, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}

@Composable
fun PopularContent(books: Element?) {
    Column(modifier = Modifier.padding(start = 16.dp)) {
        Text(books?.header!!, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(books.componentItems ?: emptyList()) { item ->
                val media = item.mediaData
                PopularBookCard(
                    imageUrl = media.cover.fullUrl,
                    title = media.title,
                    subtitle = media.description,
                    cta = "Listen now"
                )
            }
        }
    }
}

package com.practical.task.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practical.task.R
import com.practical.task.data.model.Element
import com.practical.task.ui.theme.SeeAllBtnColor
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun RecommendedBookSection(books: Element?) {
    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            books?.header?.let { header ->
                Text(
                    text = header, fontWeight = FontWeight.Bold, fontSize = 18.sp
                )
            }
            TextButton(onClick = {}) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "See all", color = SeeAllBtnColor
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_right_arrow),
                        contentDescription = "Arrow Icon",
                        tint = SeeAllBtnColor
                    )
                }
            }
        }

        books?.subheader?.let { subHeader ->
            Text(
                text = subHeader,
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))


        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(books?.componentItems ?: emptyList()) { item ->
                val media = item.mediaData
                BookCover(media.cover.fullUrl.orEmpty())
            }
        }
    }
}

@Composable
fun BookCover(imageUrl: String) {
    CoilImage(
        imageModel = { imageUrl },
        modifier = Modifier
            .width(120.dp)
            .height(180.dp)
            .clip(RoundedCornerShape(8.dp)),
    )
}

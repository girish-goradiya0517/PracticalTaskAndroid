package com.practical.task.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practical.task.R
import com.practical.task.data.model.Element
import com.practical.task.data.model.MediaData2
import com.practical.task.ui.theme.CardColor
import com.practical.task.ui.theme.SeeAllBtnColor
import com.skydoves.landscapist.coil.CoilImage


@Composable
fun AudioBooks(
    books: Element?, onSeeAllClick: () -> Unit
) {
    val bookList = books?.componentItems
    Column(
        modifier = Modifier.padding(12.dp)

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            books?.header?.let { Text(it, fontWeight = FontWeight.Bold, fontSize = 18.sp) }
            TextButton(onClick = onSeeAllClick) {
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

        Spacer(modifier = Modifier.height(8.dp))
        bookList?.take(3)?.forEach { item ->
            val media = item.mediaData
            BookItem(media)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }

}


@Composable
fun BookItem(media: MediaData2) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(CardColor)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CoilImage(
            imageModel = { media.cover.fullUrl },
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = media.title,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "${media.authors[0].firstName} ${media.authors[0].lastName}",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}

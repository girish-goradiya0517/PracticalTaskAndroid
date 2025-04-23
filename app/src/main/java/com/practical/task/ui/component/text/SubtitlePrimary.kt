package com.practical.task.ui.component.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.practical.task.ui.theme.subTitlePrimary

@Composable
fun SubtitlePrimary(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.subTitlePrimary
    )
}

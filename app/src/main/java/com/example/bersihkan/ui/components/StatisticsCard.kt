package com.example.bersihkan.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bersihkan.ui.theme.BersihKanTheme
import com.example.bersihkan.ui.theme.Cerulean
import com.example.bersihkan.ui.theme.Java
import com.example.bersihkan.ui.theme.Shapes
import com.example.bersihkan.ui.theme.headlineExtraLarge
import com.example.bersihkan.ui.theme.subHeadlineExtraLarge
import com.example.bersihkan.ui.theme.textRegularSmall

@Composable
fun StatisticsCard(
    count: String,
    title: String,
    desc: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        color = backgroundColor,
        contentColor = Color.White,
        modifier = modifier
            .size(185.dp, 175.dp)
            .clip(Shapes.large)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = count,
                style = headlineExtraLarge,
                modifier = Modifier
                    .height(78.dp)
            )
            Box {
                Text(
                    text = title,
                    style = subHeadlineExtraLarge
                )
                Text(
                    text = desc,
                    style = textRegularSmall,
                    modifier = Modifier.padding(top = 24.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StatisticsCardPreview() {
    BersihKanTheme {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            content = {
            item {
                StatisticsCard(
                    count = "12",
                    title = "order(s)",
                    desc = "have been\nmade",
                    backgroundColor = Java
                )
            }
            item {
                StatisticsCard(
                    count = "3.5",
                    title = "kg of waste",
                    desc = "have been\ncollected",
                    backgroundColor = Cerulean
                )
            }
            item {
                StatisticsCard(
                    count = "2",
                    title = "type of waste",
                    desc = "have been\nrecycled",
                    backgroundColor = Java
                )
            }
        })
    }
}
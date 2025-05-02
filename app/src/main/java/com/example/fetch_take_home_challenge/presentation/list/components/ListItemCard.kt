package com.example.fetch_take_home_challenge.presentation.list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetch_take_home_challenge.domain.model.ListItem
import com.example.fetch_take_home_challenge.presentation.theme.ui.FetchtakehomechallengeTheme

@Composable
fun ListItemCard(
    list: List<ListItem>,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        for (item in list) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(vertical = 32.dp)
            ) {
                Text(
                    text = item.name!!,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )

                Text(
                    text = "ID: ${item.id.toString()}",
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            }
            HorizontalDivider(modifier = Modifier.padding(horizontal = 32.dp))
        }

    }

}

@Preview
@Composable
fun ListItemCardPreview(modifier: Modifier = Modifier) {
    FetchtakehomechallengeTheme {
        ListItemCard(
            list = previewList,
        )
    }
}

internal val previewList = listOf(
    ListItem(54, 1, "Item"),
    ListItem(55, 1, "Item"),
    ListItem(56, 1, "Item")
)

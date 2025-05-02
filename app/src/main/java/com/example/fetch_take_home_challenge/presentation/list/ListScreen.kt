package com.example.fetch_take_home_challenge.presentation.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetch_take_home_challenge.presentation.list.components.ListItemCard

@Composable
fun ListScreen(
    state: ListState,
    modifier: Modifier = Modifier
) {
    if (state.isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(top = 32.dp)
                .padding(bottom = 16.dp)
        ) {
            val list = state.list.toList().sortedBy { it.first }
            item {
                for (item in list) {
                    Text(
                        text = "List ${item.first}",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .padding(top = 32.dp)
                    )
                    ListItemCard(item.second.sortedBy { it.name })
                }
            }
        }
    }
}
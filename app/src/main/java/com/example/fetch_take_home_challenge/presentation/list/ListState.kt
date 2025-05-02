package com.example.fetch_take_home_challenge.presentation.list

import com.example.fetch_take_home_challenge.domain.model.ListItem

data class ListState(
    val isLoading: Boolean = false,
    val list: Map<Int, List<ListItem>> = emptyMap()
    )
package com.example.fetch_take_home_challenge.presentation.list

import com.example.fetch_take_home_challenge.domain.model.ListItem

sealed class ListState {
    class Success(val list: Map<Int, List<ListItem>>) : ListState()
    data object Error: ListState()
    data object Loading : ListState()
}
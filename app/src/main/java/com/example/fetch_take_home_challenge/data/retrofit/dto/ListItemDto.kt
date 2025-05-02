package com.example.fetch_take_home_challenge.data.retrofit.dto

import com.example.fetch_take_home_challenge.domain.model.ListItem
import com.google.gson.annotations.SerializedName

data class ListItemDto (
    @SerializedName("id")
    val id: Int,
    @SerializedName("listId")
    val listId: Int,
    @SerializedName("name")
    val name: String?
)

fun ListItemDto.toListItem() : ListItem {
    return ListItem(
        id = this.id,
        listId = this.listId,
        name = this.name
    )
}
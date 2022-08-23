package com.andromite.moviessuggestions.network.models

data class ParentItem(
    val parentTitle: String? = null,
    val childList: List<ChildItem>? = null
)

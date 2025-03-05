package com.aya.domain.model

data class Bug(
    val date: String,
    val bugs: List<BugItem>
)

data class BugItem(
    val id: String,
    val description: String,
    val imageUrl: String,
    val createdAt: String // e.g., "26-09-23"
)

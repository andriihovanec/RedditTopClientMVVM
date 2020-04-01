package com.andriikhovanets.reddittopclient.domain.posts.wrapper

data class Posts(
    val id: String?,
    val name: String?,
    val title: String?,
    val created: Long?,
    val url: String?,
    val authorName: String?,
    val commentsNumber: Int?,
    val subRedditName: String?,
    val permalink: String?,
    val score: Int?
)
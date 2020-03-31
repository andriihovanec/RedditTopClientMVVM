package com.andriikhovanets.reddittopclient.domain.posts

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.andriikhovanets.reddittopclient.cache.DatabaseContract.REDDITS_TABLE_NAME

@Entity(tableName = REDDITS_TABLE_NAME)
data class PostEntity(
    @PrimaryKey var id: Long,
    var name: String?,
    var title: String?,
    var created: Long?,
    var url: String?,
    var authorName: String?,
    var commentsNumber: Int?,
    var subRedditName: String?,
    var permalink: String?,
    var score: Int?
)
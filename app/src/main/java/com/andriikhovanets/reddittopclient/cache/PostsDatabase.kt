package com.andriikhovanets.reddittopclient.cache

import androidx.room.RoomDatabase
import com.andriikhovanets.reddittopclient.cache.posts.PostsDao

abstract class PostsDatabase : RoomDatabase() {

    abstract val postsDao: PostsDao
}
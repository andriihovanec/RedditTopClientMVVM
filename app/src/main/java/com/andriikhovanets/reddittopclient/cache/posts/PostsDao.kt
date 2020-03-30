package com.andriikhovanets.reddittopclient.cache.posts

import androidx.room.Dao
import com.andriikhovanets.reddittopclient.data.PostsCache
import com.andriikhovanets.reddittopclient.domain.posts.PostEntity

@Dao
interface PostsDao : PostsCache {
    override fun getPosts(): List<PostEntity>

    override fun savePosts(posts: List<PostEntity>)
}
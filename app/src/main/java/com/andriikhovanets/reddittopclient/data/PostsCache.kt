package com.andriikhovanets.reddittopclient.data

import com.andriikhovanets.reddittopclient.domain.posts.PostEntity

interface PostsCache {
    fun getPosts(): List<PostEntity>
    fun insertPosts(postEntity: List<PostEntity>)
    fun getAfterPosts(after: String): List<PostEntity>
}
package com.andriikhovanets.reddittopclient.data

import com.andriikhovanets.reddittopclient.domain.posts.PostEntity

interface PostsCache {
    fun getPosts(): List<PostEntity>
}
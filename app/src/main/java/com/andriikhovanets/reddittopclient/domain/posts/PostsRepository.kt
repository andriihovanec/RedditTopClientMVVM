package com.andriikhovanets.reddittopclient.domain.posts

interface PostsRepository {
    fun getPosts(limit: Int, after: String?): List<PostEntity>
}
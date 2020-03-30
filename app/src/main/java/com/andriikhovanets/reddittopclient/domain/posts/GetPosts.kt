package com.andriikhovanets.reddittopclient.domain.posts

import com.andriikhovanets.reddittopclient.domain.interactor.UseCase

class GetPosts(private val postsRepository: PostsRepository) : UseCase<List<PostEntity>, Boolean>() {
    override suspend fun run(params: Boolean) = postsRepository.getPosts(params)
}
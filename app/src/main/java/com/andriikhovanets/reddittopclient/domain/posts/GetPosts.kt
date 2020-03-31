package com.andriikhovanets.reddittopclient.domain.posts

import com.andriikhovanets.reddittopclient.domain.interactor.UseCase
import javax.inject.Inject

class GetPosts @Inject constructor(private val postsRepository: PostsRepository) :
    UseCase<List<PostEntity>, GetPosts.Params>() {

    override suspend fun run(params: Params) =
        postsRepository.getPosts(params.limit, params.after, params.needFetch)

    data class Params(val limit: Int, val after: String?, val needFetch: Boolean)
}
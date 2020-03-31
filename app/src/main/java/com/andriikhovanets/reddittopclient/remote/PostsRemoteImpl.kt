package com.andriikhovanets.reddittopclient.remote

import com.andriikhovanets.reddittopclient.data.PostsRemote
import com.andriikhovanets.reddittopclient.domain.Either
import com.andriikhovanets.reddittopclient.domain.Failure
import com.andriikhovanets.reddittopclient.domain.posts.PostEntity
import com.andriikhovanets.reddittopclient.remote.core.Request
import com.andriikhovanets.reddittopclient.remote.service.ApiService
import javax.inject.Inject

class PostsRemoteImpl @Inject constructor(
    private val request: Request,
    private val service: ApiService
) : PostsRemote {

    override fun getPosts(limit: Int, after: String?): Either<Failure, List<PostEntity>> {
        return request.make(service.getTopReddits(limit, after)) {
            it.posts
        }
    }
}
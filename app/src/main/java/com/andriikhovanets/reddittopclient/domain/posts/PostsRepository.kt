package com.andriikhovanets.reddittopclient.domain.posts

import com.andriikhovanets.reddittopclient.domain.Either
import com.andriikhovanets.reddittopclient.domain.Failure

interface PostsRepository {
    fun getPosts(needFetch: Boolean): Either<Failure, List<PostEntity>>
}
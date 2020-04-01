package com.andriikhovanets.reddittopclient.data

import com.andriikhovanets.reddittopclient.domain.Either
import com.andriikhovanets.reddittopclient.domain.Failure
import com.andriikhovanets.reddittopclient.domain.posts.wrapper.RedditWrapper

interface PostsRemote {
    fun getPosts(limit: Int, after: String?): Either<Failure, RedditWrapper>
}
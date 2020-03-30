package com.andriikhovanets.reddittopclient.data

import com.andriikhovanets.reddittopclient.BuildConfig
import com.andriikhovanets.reddittopclient.domain.Either
import com.andriikhovanets.reddittopclient.domain.Failure
import com.andriikhovanets.reddittopclient.domain.posts.PostEntity
import com.andriikhovanets.reddittopclient.domain.posts.PostsRepository

class PostsRepositoryImpl(
    private val postsCache: PostsCache,
    private val postsRemote: PostsRemote
) : PostsRepository {

    override fun getPosts(needFetch: Boolean): Either<Failure, List<PostEntity>> {
        return if (needFetch){
            postsRemote.getPosts()
        } else {
            Either.Right(postsCache.getPosts())
        }
    }
}
package com.andriikhovanets.reddittopclient.data

import com.andriikhovanets.reddittopclient.domain.Either
import com.andriikhovanets.reddittopclient.domain.Failure
import com.andriikhovanets.reddittopclient.domain.onNext
import com.andriikhovanets.reddittopclient.domain.posts.PostEntity
import com.andriikhovanets.reddittopclient.domain.posts.PostsRepository

class PostsRepositoryImpl(
    private val postsCache: PostsCache,
    private val postsRemote: PostsRemote
) : PostsRepository {

    override fun getPosts(
        limit: Int,
        after: String?,
        needFetch: Boolean
    ): Either<Failure, List<PostEntity>> {

        return if (needFetch) {
            postsRemote.getPosts(limit, after).onNext {
                postsCache.savePosts(it)
            }
        } else {
            Either.Right(postsCache.getPosts())
        }
    }
}
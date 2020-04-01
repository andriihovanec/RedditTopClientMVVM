package com.andriikhovanets.reddittopclient.data

import com.andriikhovanets.reddittopclient.domain.Either
import com.andriikhovanets.reddittopclient.domain.Failure
import com.andriikhovanets.reddittopclient.domain.onNext
import com.andriikhovanets.reddittopclient.domain.posts.PostEntity
import com.andriikhovanets.reddittopclient.domain.posts.PostsRepository

class PostsRepositoryImpl(
    private val postsRemote: PostsRemote,
    private val postsCache: PostsCache
) : PostsRepository {

    override fun getPosts(
        limit: Int,
        after: String?,
        needFetch: Boolean
    ): Either<Failure, List<PostEntity>> {

        return if (needFetch) {
            val posts = mutableListOf<PostEntity>()
            postsRemote.getPosts(limit, after).onNext { wrapper ->
                wrapper.data?.children?.map { list ->
                    posts.add(list.post!!)
                }
                postsCache.insertPosts(posts.toList())
            }
            Either.Right(posts.toList())
        } else {
            Either.Right(postsCache.getPosts())
        }
    }
}
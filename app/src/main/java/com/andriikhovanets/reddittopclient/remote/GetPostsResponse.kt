package com.andriikhovanets.reddittopclient.remote

import com.andriikhovanets.reddittopclient.domain.posts.PostEntity
import com.andriikhovanets.reddittopclient.remote.core.BaseResponse

class GetPostsResponse(
    success: Int,
    message: String,
    val posts: List<PostEntity>
) : BaseResponse(success, message)
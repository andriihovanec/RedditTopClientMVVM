package com.andriikhovanets.reddittopclient.remote

import com.andriikhovanets.reddittopclient.domain.posts.wrapper.RedditWrapper
import com.andriikhovanets.reddittopclient.remote.core.BaseResponse

class GetPostsResponse(
    success: Int,
    message: String,
    val postsWrapper: RedditWrapper
) : BaseResponse(success, message)
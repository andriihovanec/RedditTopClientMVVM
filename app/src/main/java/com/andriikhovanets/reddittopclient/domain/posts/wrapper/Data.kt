package com.andriikhovanets.reddittopclient.domain.posts.wrapper

import com.andriikhovanets.reddittopclient.domain.posts.wrapper.Children

data class Data(
    val children: List<Children>? = null,
    val after: String? = null,
    val before: Any? = null
)
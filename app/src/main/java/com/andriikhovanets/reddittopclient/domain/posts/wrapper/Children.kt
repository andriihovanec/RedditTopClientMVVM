package com.andriikhovanets.reddittopclient.domain.posts.wrapper

import com.andriikhovanets.reddittopclient.domain.posts.PostEntity

data class Children(val kind: String? = null,
               val post: PostEntity? = null)
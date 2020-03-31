package com.andriikhovanets.reddittopclient.remote.service

import com.andriikhovanets.reddittopclient.remote.GetPostsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top.json")
    fun getTopReddits(
        @Query("limit") limit: Int?,
        @Query("after") after: String?
    ): Call<GetPostsResponse>
}
package com.andriikhovanets.reddittopclient.cache.posts

import androidx.room.*
import com.andriikhovanets.reddittopclient.cache.DatabaseContract.REDDITS_TABLE_NAME
import com.andriikhovanets.reddittopclient.data.PostsCache
import com.andriikhovanets.reddittopclient.domain.posts.PostEntity

@Dao
interface PostsDao : PostsCache {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    override fun insertPosts(postEntity: List<PostEntity>)

    @Query("SELECT * from $REDDITS_TABLE_NAME")
    override fun getPosts(): List<PostEntity>

    @Query("SELECT * FROM $REDDITS_TABLE_NAME WHERE created > (SELECT created FROM $REDDITS_TABLE_NAME WHERE name=:after)")
    override fun getAfterPosts(after: String): List<PostEntity>
}
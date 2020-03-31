package com.andriikhovanets.reddittopclient.presentation.injection

import android.content.Context
import com.andriikhovanets.reddittopclient.cache.RedditDatabase
import com.andriikhovanets.reddittopclient.data.PostsCache
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

    @Provides
    @Singleton
    fun provideRedditDatabase(context: Context): RedditDatabase {
        return RedditDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun providePostsCache(redditDatabase: RedditDatabase): PostsCache {
        return redditDatabase.postsDao
    }
}
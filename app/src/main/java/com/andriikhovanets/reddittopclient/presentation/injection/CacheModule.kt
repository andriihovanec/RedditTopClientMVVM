package com.andriikhovanets.reddittopclient.presentation.injection

import com.andriikhovanets.reddittopclient.cache.PostsDatabase
import com.andriikhovanets.reddittopclient.data.PostsCache
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

    @Provides
    @Singleton
    fun providePostsCache(postsDatabase: PostsDatabase): PostsCache {
        return postsDatabase.postsDao
    }
}
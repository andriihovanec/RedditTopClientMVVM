package com.andriikhovanets.reddittopclient.presentation.injection

import android.content.Context
import com.andriikhovanets.reddittopclient.data.PostsCache
import com.andriikhovanets.reddittopclient.data.PostsRemote
import com.andriikhovanets.reddittopclient.data.PostsRepositoryImpl
import com.andriikhovanets.reddittopclient.domain.posts.PostsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideAppContext(): Context = context

    @Provides
    @Singleton
    fun providePostsRepository(remote: PostsRemote, cache: PostsCache): PostsRepository {
        return PostsRepositoryImpl(remote, cache)
    }
}
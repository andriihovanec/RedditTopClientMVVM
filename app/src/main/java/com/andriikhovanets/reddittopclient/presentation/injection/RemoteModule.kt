package com.andriikhovanets.reddittopclient.presentation.injection

import com.andriikhovanets.reddittopclient.BuildConfig
import com.andriikhovanets.reddittopclient.data.PostsRemote
import com.andriikhovanets.reddittopclient.remote.PostsRemoteImpl
import com.andriikhovanets.reddittopclient.remote.core.Request
import com.andriikhovanets.reddittopclient.remote.service.ApiService
import com.andriikhovanets.reddittopclient.remote.service.ServiceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService = ServiceFactory.makeService(BuildConfig.DEBUG)

    @Singleton
    @Provides
    fun providePostsRemote(request: Request, apiService: ApiService): PostsRemote {
        return PostsRemoteImpl(request, apiService)
    }
}
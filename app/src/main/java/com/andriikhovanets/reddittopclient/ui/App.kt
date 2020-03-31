package com.andriikhovanets.reddittopclient.ui

import android.app.Application
import com.andriikhovanets.reddittopclient.presentation.injection.AppModule
import com.andriikhovanets.reddittopclient.presentation.injection.CacheModule
import com.andriikhovanets.reddittopclient.presentation.injection.RemoteModule
import com.andriikhovanets.reddittopclient.ui.posts.PostsFragment
import dagger.Component
import javax.inject.Singleton

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()
    }
}

@Singleton
@Component(modules = [AppModule::class, CacheModule::class, RemoteModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: PostsFragment)
}
package com.andriikhovanets.reddittopclient.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.andriikhovanets.reddittopclient.cache.DatabaseContract.DATABASE_NAME
import com.andriikhovanets.reddittopclient.cache.DatabaseContract.DATABASE_VERSION
import com.andriikhovanets.reddittopclient.cache.posts.PostsDao
import com.andriikhovanets.reddittopclient.domain.posts.PostEntity

@Database(entities = [PostEntity::class], version = DATABASE_VERSION, exportSchema = false)
abstract class RedditDatabase : RoomDatabase() {

    abstract val postsDao: PostsDao

    companion object {
        @Volatile
        private var INSTANCE: RedditDatabase? = null

        fun getInstance(context: Context): RedditDatabase {

            var instance = INSTANCE

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    RedditDatabase::class.java,
                    DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
            }

            return instance
        }
    }
}
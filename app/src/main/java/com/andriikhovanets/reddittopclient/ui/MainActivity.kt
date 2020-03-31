package com.andriikhovanets.reddittopclient.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.andriikhovanets.reddittopclient.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.appComponent.inject(this)
    }
}

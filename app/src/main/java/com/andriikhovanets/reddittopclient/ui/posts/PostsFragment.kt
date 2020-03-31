package com.andriikhovanets.reddittopclient.ui.posts

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.andriikhovanets.reddittopclient.R
import com.andriikhovanets.reddittopclient.presentation.viewmodel.PostsViewModel
import com.andriikhovanets.reddittopclient.ui.App
import javax.inject.Inject

class PostsFragment : Fragment(R.layout.fragment_reddit_list) {

    lateinit var viewModel: PostsViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(PostsViewModel::class.java)

        viewModel = ViewModelProvider(this,viewModelFactory)[PostsViewModel::class.java]
    }
}

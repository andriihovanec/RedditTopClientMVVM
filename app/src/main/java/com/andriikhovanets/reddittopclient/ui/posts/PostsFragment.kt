package com.andriikhovanets.reddittopclient.ui.posts

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.andriikhovanets.reddittopclient.R
import com.andriikhovanets.reddittopclient.presentation.viewmodel.PostsViewModel

class PostsFragment : Fragment(R.layout.fragment_reddit_list) {

    private lateinit var viewModel: PostsViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PostsViewModel::class.java)
    }

}

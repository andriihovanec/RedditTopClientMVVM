package com.andriikhovanets.reddittopclient.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.andriikhovanets.reddittopclient.R

class RedditListFragment : Fragment(R.layout.fragment_reddit_list) {

    private lateinit var viewModel: RedditListViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RedditListViewModel::class.java)
    }

}

package com.andriikhovanets.reddittopclient.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.andriikhovanets.reddittopclient.domain.posts.GetPosts
import com.andriikhovanets.reddittopclient.domain.posts.PostEntity
import javax.inject.Inject

class PostsViewModel @Inject constructor(val getPostsUseCase: GetPosts) : BaseViewModel() {

    private val _postsData = MutableLiveData<List<PostEntity>>()
    val postData = _postsData

    fun getPosts() {
        getPostsUseCase(GetPosts.Params(10, "", true)) {
            it.either(
                ::handleFailure,
                ::handlePostsReceived
            )
        }
    }

    private fun handlePostsReceived(posts: List<PostEntity>) {
        _postsData.value = posts
    }

    override fun onCleared() {
        super.onCleared()
        getPostsUseCase.unsubscribe()
    }
}

package com.andriikhovanets.reddittopclient.presentation

import androidx.lifecycle.MutableLiveData
import com.andriikhovanets.reddittopclient.domain.posts.GetPosts
import com.andriikhovanets.reddittopclient.domain.posts.PostEntity

class PostsViewModel(val getPostsUseCase: GetPosts) : BaseViewModel() {

    val postsData = MutableLiveData<List<PostEntity>>()

    fun getPosts() {
        getPostsUseCase(GetPosts.Params(10, "", true)) {
            it.either(
                ::handleFailure,
                ::handlePostsReceived
            )
        }
    }

    private fun handlePostsReceived(posts: List<PostEntity>) {
        postsData.value = posts
    }

    override fun onCleared() {
        super.onCleared()
        getPostsUseCase.unsubscribe()
    }
}

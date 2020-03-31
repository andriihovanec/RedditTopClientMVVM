package com.andriikhovanets.reddittopclient.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andriikhovanets.reddittopclient.domain.Failure
import com.andriikhovanets.reddittopclient.domain.HandleOnce

open class BaseViewModel : ViewModel() {
    var failureData: MutableLiveData<HandleOnce<Failure>> = MutableLiveData()

    protected fun handleFailure(failure: Failure) {
        failureData.value = HandleOnce(failure)
    }
}
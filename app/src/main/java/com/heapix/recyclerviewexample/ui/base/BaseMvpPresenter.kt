package com.heapix.recyclerviewexample.ui.base

import androidx.annotation.StringRes
import com.arellomobile.mvp.MvpPresenter
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class BaseMvpPresenter<V : BaseMvpView> : MvpPresenter<V>() {

    init {
//        EventBus.getDefault().register(this)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    //    @Subscribe
    fun onEvent(anyEvent: Any) {

        //default method
    }

    protected fun showMessage(@StringRes text: Int) {
        viewState.showMessage(text)
    }

    protected fun showMessage(text: String) {
        viewState.showMessage(text)
    }

    fun processNetworkException(it: Throwable?, showMessage: Boolean = true): Boolean {
        if (it is HttpException) {
            if (it.code() == 401 || it.code() == 403) {
//                EventBus.getDefault().post(ProtocolExceptionEvent())

                return true
            }
        }

        if (it is SocketTimeoutException) {
            if (showMessage)
//                showMessage(R.string.socketTimeoutException)

                return true
        } else if (it is ConnectException || it is UnknownHostException) {
            if (showMessage)
//                showMessage(R.string.connectException)

                return true
        }

        return false
    }

}

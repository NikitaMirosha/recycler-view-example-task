package com.heapix.recyclerviewexample.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes

abstract class BaseMvpFragment : MvpFragment(), BaseMvpView {

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun onViewCreated(view: View)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        initViews(view)
        onViewCreated(view)
    }

    override fun showMessage(resId: Int) {
        (activity as? BaseMvpActivity)?.showMessage(resId)
    }

    override fun showMessage(msg: String?) {
        (activity as? BaseMvpActivity)?.showMessage(msg)
    }

    override fun handleRestError(e: Throwable) {
        (activity as? BaseMvpActivity)?.handleRestError(e)
    }

    fun showKeyboard(view: View) {
        val inputMethodManager: InputMethodManager =
            context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(view, 0)
    }

    fun hideKeyboard(view: View) {
        val inputMethodManager: InputMethodManager =
            context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    open fun scrollToTheTop() {}
}
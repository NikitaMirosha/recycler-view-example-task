package com.heapix.recyclerviewexample.ui.base

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.MvpDelegate

open class MvpFragment : Fragment() {

    private var mIsStateSaved: Boolean = false
    private var mMvpDelegate: MvpDelegate<out MvpFragment>? = null

    /**
     * @return The [MvpDelegate] being used by this Fragment.
     */
    val mvpDelegate: MvpDelegate<out MvpFragment>
        get() {
            if (mMvpDelegate == null) {
                mMvpDelegate = MvpDelegate(this)
            }

            return mMvpDelegate!!
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mvpDelegate.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

        mIsStateSaved = false

        mvpDelegate.onAttach()
    }

    override fun onResume() {
        super.onResume()

        mIsStateSaved = false

        mvpDelegate.onAttach()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        mIsStateSaved = true

        mvpDelegate.onSaveInstanceState(outState)
        mvpDelegate.onDetach()
    }

    override fun onStop() {
        super.onStop()

        mvpDelegate.onDetach()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        mvpDelegate.onDetach()
        mvpDelegate.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()

        //We leave the screen and respectively all fragments will be destroyed
        if (activity?.isFinishing == true) {
            mvpDelegate.onDestroy()
            return
        }

        // When we rotate device isRemoving() return true for fragment placed in backstack
        // http://stackoverflow.com/questions/34649126/fragment-back-stack-and-isremoving
        if (mIsStateSaved) {
            mIsStateSaved = false
            return
        }

        // See https://github.com/Arello-Mobile/Moxy/issues/24
        var anyParentIsRemoving = false

        if (Build.VERSION.SDK_INT >= 17) {
            var parent: Fragment? = parentFragment
            while (!anyParentIsRemoving && parent != null) {
                anyParentIsRemoving = parent.isRemoving
                parent = parent.parentFragment
            }
        }

        if (isRemoving || anyParentIsRemoving) {
            mvpDelegate.onDestroy()
        }
    }
}
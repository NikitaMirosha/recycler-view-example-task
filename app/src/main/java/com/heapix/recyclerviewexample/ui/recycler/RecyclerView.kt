package com.heapix.recyclerviewexample.ui.recycler

import com.heapix.recyclerviewexample.model.Recycler
import com.heapix.recyclerviewexample.ui.base.BaseMvpView

interface RecyclerView : BaseMvpView {
    fun updateRecycler(recyclerList: MutableList<Recycler>)
    fun showDefaultRecycler()
}
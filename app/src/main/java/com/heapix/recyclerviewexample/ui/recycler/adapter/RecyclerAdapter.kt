package com.heapix.recyclerviewexample.ui.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.heapix.recyclerviewexample.R
import com.heapix.recyclerviewexample.model.Recycler
import com.heapix.recyclerviewexample.ui.base.adapters.BaseListAdapter
import com.heapix.recyclerviewexample.ui.base.adapters.BaseViewHolder
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class RecyclerAdapter : BaseListAdapter<Recycler>() {

    private val recyclerPublishSubject: PublishSubject<Recycler> = PublishSubject.create()

    private val linear = 0
    private val grid = 1

    override fun getItemViewType(position: Int) = when (items[position]) {
        is Recycler.Linear -> linear
        is Recycler.Grid -> grid
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<Recycler> {

        return when (viewType) {
            linear -> LinearViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_recycler,
                    parent,
                    false
                ),
                recyclerPublishSubject
            )
            grid -> GridViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_recycler,
                    parent,
                    false
                ),
                recyclerPublishSubject
            )
            else -> throw NotImplementedError()
        }
    }

}
package com.heapix.recyclerviewexample.ui.recycler.adapter

import android.view.View
import com.heapix.recyclerviewexample.model.Recycler
import com.heapix.recyclerviewexample.ui.base.adapters.BaseViewHolder
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_recycler.*

class GridViewHolder(
    itemView: View,
    private val recyclerPublishSubject: PublishSubject<Recycler>
) : BaseViewHolder<Recycler>(itemView) {

    override fun bind(model: Recycler) {
        setupItemName(model)
        setupClickListener(model)
    }

    private fun setupItemName(recycler: Recycler) {
        vTvItemName.text = (recycler as Recycler.Grid).gridModel.numberGrid.toString()
    }

    private fun setupClickListener(recycler: Recycler) {
        setOnClickListener {
            recyclerPublishSubject.onNext(recycler)
        }
    }
}
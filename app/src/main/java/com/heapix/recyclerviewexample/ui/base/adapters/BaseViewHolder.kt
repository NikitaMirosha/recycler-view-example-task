package com.heapix.recyclerviewexample.ui.base.adapters


import android.content.Context
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

/**
 * Base class for all view holders to be used in concrete implementations of [BaseListAdapter]
 */
/**
 * Base class for all view holders to be used in concrete implementations of [BaseListAdapter]
 */
abstract class BaseViewHolder<in T>(view: View) : RecyclerView.ViewHolder(view), LayoutContainer {

    abstract fun bind(model: T)

    override val containerView: View?
        get() = itemView

    val context: Context
        get() = itemView.context

    fun setOnClickListener(block: () -> Unit) {
        itemView.setOnClickListener {
            block()
        }
    }

    fun getColor(@ColorRes color: Int) = ContextCompat.getColor(itemView.context, color)
}
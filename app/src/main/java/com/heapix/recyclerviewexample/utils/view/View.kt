package com.insspring.poifox.utils.view

import android.view.View


fun View.show() {
    if (this.visibility != View.VISIBLE)
        this.visibility = View.VISIBLE
}

fun View.hide() {
    if (this.visibility != View.GONE)
        this.visibility = View.GONE
}
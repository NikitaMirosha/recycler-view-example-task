package com.heapix.recyclerviewexample.model

sealed class Recycler {
    class Linear(val linearModel: LinearModel) : Recycler()
    class Grid(val gridModel: GridModel) : Recycler()
}
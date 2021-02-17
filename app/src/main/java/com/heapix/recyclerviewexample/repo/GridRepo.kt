package com.heapix.recyclerviewexample.repo

import com.heapix.recyclerviewexample.model.GridModel
import com.heapix.recyclerviewexample.model.Recycler

class GridRepo {

    fun getAllGrids(): MutableList<Recycler> {
        val gridModelList = mutableListOf<Recycler>()
        (0..1500).forEach { numberGrid -> gridModelList.add(Recycler.Grid(GridModel(numberGrid))) }
        return gridModelList
    }
}
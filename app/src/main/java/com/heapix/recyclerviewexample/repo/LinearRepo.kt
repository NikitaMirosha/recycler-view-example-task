package com.heapix.recyclerviewexample.repo

import com.heapix.recyclerviewexample.model.LinearModel
import com.heapix.recyclerviewexample.model.Recycler

class LinearRepo {

    fun getAllLinears(): MutableList<Recycler> {
        val linearModelList = mutableListOf<Recycler>()
        (0..1500).forEach { numberLinear ->
            linearModelList.add(
                Recycler.Linear(
                    LinearModel(
                        numberLinear
                    )
                )
            )
        }
        return linearModelList
    }

}
package com.heapix.recyclerviewexample.ui.recycler

import com.arellomobile.mvp.InjectViewState
import com.heapix.recyclerviewexample.RecyclerType
import com.heapix.recyclerviewexample.model.Recycler
import com.heapix.recyclerviewexample.repo.GridRepo
import com.heapix.recyclerviewexample.repo.LinearRepo
import com.heapix.recyclerviewexample.ui.base.BaseMvpPresenter
import io.reactivex.Observable

@InjectViewState
class RecyclerPresenter : BaseMvpPresenter<RecyclerView>() {

    private val linearRepo: LinearRepo = LinearRepo()
    private val gridRepo: GridRepo = GridRepo()

    fun onCreate() {
        viewState.showDefaultRecycler()
        getRecyclerAndUpdateUi()
    }

    private fun getRecyclerAndUpdateUi(newsType: RecyclerType = RecyclerType.LINEAR_VERTICAL) {
        when (newsType) {
            RecyclerType.LINEAR_VERTICAL -> viewState.updateRecycler(linearRepo.getAllLinears())
            RecyclerType.GRID_VERTICAL -> viewState.updateRecycler(gridRepo.getAllGrids())
        }
    }

    fun onTabChanged(recyclerType: RecyclerType) = getRecyclerAndUpdateUi(recyclerType)
}
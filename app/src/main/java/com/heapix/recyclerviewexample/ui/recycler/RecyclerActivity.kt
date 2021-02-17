package com.heapix.recyclerviewexample.ui.recycler

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.google.android.material.tabs.TabLayout
import com.heapix.recyclerviewexample.R
import com.heapix.recyclerviewexample.RecyclerType
import com.heapix.recyclerviewexample.model.Recycler
import com.heapix.recyclerviewexample.ui.base.BaseMvpActivity
import com.heapix.recyclerviewexample.ui.recycler.adapter.RecyclerAdapter
import com.heapix.recyclerviewexample.utils.SimpleOnTabSelectedListener
import kotlinx.android.synthetic.main.fragment_recycler.*
import kotlinx.android.synthetic.main.item_recycler.*

class RecyclerActivity : BaseMvpActivity(), RecyclerView {

    @InjectPresenter
    lateinit var recyclerPresenter: RecyclerPresenter

    lateinit var recyclerAdapter: RecyclerAdapter

    override fun getLayoutId(): Int = R.layout.fragment_recycler

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        setupRecyclerAdapter()
        setupRecyclerTabListeners()
        recyclerPresenter.onCreate()
    }

    private fun setupRecyclerAdapter() {
        recyclerAdapter = RecyclerAdapter()
        vRvRecyclerList.adapter = recyclerAdapter
    }

    private fun setupRecyclerTabListeners() {
        vTlRecyclerNavigation.addOnTabSelectedListener(object : SimpleOnTabSelectedListener() {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    RecyclerType.LINEAR_VERTICAL.value -> {
                        vRvRecyclerList.layoutManager = LinearLayoutManager(
                            this@RecyclerActivity,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                        recyclerPresenter.onTabChanged(RecyclerType.LINEAR_VERTICAL)
                    }

                    RecyclerType.LINEAR_HORIZONTAL.value -> {
                        vRvRecyclerList.layoutManager = LinearLayoutManager(
                            this@RecyclerActivity,
                            LinearLayoutManager.HORIZONTAL,
                            false
                        )
                        recyclerPresenter.onTabChanged(RecyclerType.LINEAR_VERTICAL)
                    }

                    RecyclerType.GRID_VERTICAL.value -> {
                        vRvRecyclerList.layoutManager = GridLayoutManager(
                            this@RecyclerActivity,
                            3
                        )
                        recyclerPresenter.onTabChanged(RecyclerType.GRID_VERTICAL)
                    }

                    RecyclerType.GRID_HORIZONTAL.value -> {
                        vRvRecyclerList.layoutManager = GridLayoutManager(
                            this@RecyclerActivity,
                            6,
                            GridLayoutManager.HORIZONTAL,
                            false
                        )
                        recyclerPresenter.onTabChanged(RecyclerType.GRID_HORIZONTAL)
                    }
                }
            }
        })
    }

    override fun updateRecycler(recyclerList: MutableList<Recycler>) =
        recyclerAdapter.setItems(recyclerList)

    override fun showDefaultRecycler() {
        vRvRecyclerList.layoutManager = LinearLayoutManager(
            this@RecyclerActivity,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerPresenter.onTabChanged(RecyclerType.LINEAR_VERTICAL)
    }

}
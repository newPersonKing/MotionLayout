package com.gy.motionlayout

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  layoutList = arrayListOf(R.layout.demo1,R.layout.demo2)

        val demoList = arrayListOf<DemoAdapter.Demo>()
        for (i in 0 until layoutList.size){
            demoList.add(DemoAdapter.Demo("DEMO ${i+1}", layoutList[i]))
        }

        val adapter = DemoAdapter(demoList)

        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))

        recyclerView.adapter = adapter

    }

    fun start(layoutFileId: Int){
        val  intent = Intent(this,CarouselActivity::class.java).apply {
            putExtra("layout_file_id", layoutFileId)
        }
        startActivity(intent)
    }
}

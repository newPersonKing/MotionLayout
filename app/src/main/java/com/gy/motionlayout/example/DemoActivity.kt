package com.gy.motionlayout.example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.gy.motionlayout.CarouselActivity
import com.gy.motionlayout.R
import com.gy.motionlayout.example.activity.*

class DemoActivity : AppCompatActivity(){

    private lateinit var mAdapter : MainAdapter
    private lateinit var mLayoutManager : androidx.recyclerview.widget.LinearLayoutManager

    private val mAdapterData : Array<MainAdapter.Demo> = arrayOf(
            MainAdapter.Demo("Basic Collapsing Toolbar", ExampleTypes.DEFAULT, R.layout.collapsing_toolbar),
            MainAdapter.Demo("Collapsing Toolbar w/ Text Interpolation", ExampleTypes.DEFAULT, R.layout.collapsing_toolbar_2),
            MainAdapter.Demo("Collapsing Toolbar w/ Cover Example", ExampleTypes.FULLSCREEN, R.layout.collapsing_toolbar_with_cover),
            MainAdapter.Demo("Complex Animation Example", ExampleTypes.WITHOUT_RECYCLER_VIEW, R.layout.complex_animation_example, ComplexAnimationActivity::class.java),
            MainAdapter.Demo("Multiple Animation Example", ExampleTypes.FULLSCREEN, R.layout.multiple_animation_example, ComplexAnimationActivity::class.java),
            MainAdapter.Demo("CarouselDemo1", ExampleTypes.FULLSCREEN, R.layout.demo1, CarouselActivity::class.java),
            MainAdapter.Demo("AnimationActivity", ExampleTypes.FULLSCREEN, 0, AnimationActivity::class.java),
            MainAdapter.Demo("AnimationCardActivity", ExampleTypes.FULLSCREEN, 0, AnimationCardActivity::class.java),
            MainAdapter.Demo("AnimationCarActivity", ExampleTypes.FULLSCREEN, 0, AnimationCarActivity::class.java),
            MainAdapter.Demo("模仿华为拨号键", ExampleTypes.FULLSCREEN, 0, HuaweiTelActivity::class.java),
            MainAdapter.Demo("android 11 彩蛋", ExampleTypes.FULLSCREEN, 0, EasterEggs11Activity::class.java),
            MainAdapter.Demo("跟其他组件配合使用", ExampleTypes.FULLSCREEN, 0, ViewPagerDemoActivity::class.java)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerView)

        mAdapter = MainAdapter(mAdapterData)
        mLayoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        recyclerView.apply {
            adapter = mAdapter
            layoutManager = mLayoutManager
        }

    }

    fun start(activity:Class<*>, layoutFileId: Int, types: ExampleTypes?, position: Int){

        Log.i("cccccccc","class=="+activity.simpleName)
        val intent = Intent(this, activity).apply {
            putExtra("layoutId", layoutFileId)
            putExtra("type", types?.ordinal ?: ExampleTypes.DEFAULT.ordinal)
        }
        startActivity(intent)
    }

}
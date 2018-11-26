package com.gy.motionlayout.example

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.gy.motionlayout.R

class DemoActivity : AppCompatActivity(){

    private lateinit var mAdapter : MainAdapter
    private lateinit var mLayoutManager : LinearLayoutManager

    private val mAdapterData : Array<MainAdapter.Demo> = arrayOf(
            MainAdapter.Demo("Basic Collapsing Toolbar", ExampleTypes.DEFAULT, R.layout.collapsing_toolbar),
            MainAdapter.Demo("Collapsing Toolbar w/ Text Interpolation", ExampleTypes.DEFAULT, R.layout.collapsing_toolbar_2),
            MainAdapter.Demo("Collapsing Toolbar w/ Cover Example", ExampleTypes.FULLSCREEN, R.layout.collapsing_toolbar_with_cover),
            MainAdapter.Demo("Complex Animation Example", ExampleTypes.WITHOUT_RECYCLER_VIEW, R.layout.complex_animation_example, ComplexAnimationActivity::class.java),
            MainAdapter.Demo("Multiple Animation Example", ExampleTypes.FULLSCREEN, R.layout.multiple_animation_example, ComplexAnimationActivity::class.java),
            MainAdapter.Demo("Basic Keyframe Example", ExampleTypes.WITHOUT_RECYCLER_VIEW, R.layout.basic_key_frame_example)
//            MainAdapter.Demo("Basic Keyframe Example 2", ExampleTypes.WITHOUT_RECYCLER_VIEW, R.layout.basic_key_frame_example_2),
//            MainAdapter.Demo("Notification Center Example", ExampleTypes.DEFAULT, R.layout.notification_center_example),
//            MainAdapter.Demo("ViewPager Example", ExampleTypes.VIEW_PAGER, R.layout.viewpager_example, ViewPagerActivity::class.java),
//            MainAdapter.Demo("Youtube Fragment Transition Example", ExampleTypes.FRAGMENT, R.layout.youtube_fragment_transition_example, FragmentActivity::class.java)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        mAdapter = MainAdapter(mAdapterData)
        mLayoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            adapter = mAdapter
            layoutManager = mLayoutManager
        }

    }

    fun start(activity:Class<*>, layoutFileId: Int, types: ExampleTypes?, position: Int){

        if (position > 4) {
            Toast.makeText(this, "Coming soon...", Toast.LENGTH_LONG).show()
        } else {
            Log.i("cccccccc","class=="+activity.simpleName)
            val intent = Intent(this, activity).apply {
                putExtra("layoutId", layoutFileId)
                putExtra("type", types?.ordinal ?: ExampleTypes.DEFAULT.ordinal)
            }
            startActivity(intent)
        }
    }

}
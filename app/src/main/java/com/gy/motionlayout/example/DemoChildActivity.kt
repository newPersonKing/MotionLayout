package com.gy.motionlayout.example

import android.animation.ArgbEvaluator
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.WindowManager
import android.widget.TextView
import app.layout.motion.motionlayoutexample.DummyListAdapter
import com.gy.motionlayout.R

class DemoChildActivity : AppCompatActivity(),MotionLayout.TransitionListener{

    var motionLayout: MotionLayout? = null
    var recyclerView: RecyclerView? = null
    var layout = R.layout.collapsing_toolbar
    var exampleType = 0
    var titleTextView: TextView? = null

    var lastProgress = 0f
    private var mArgbEvaluator = ArgbEvaluator()
    private var startColor = Color.parseColor("#f48930")
    private var endColor = Color.parseColor("#b55fa3")
    private var currentColor = Color.parseColor("#b55fa3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        layout = intent.getIntExtra("layoutId", R.layout.collapsing_toolbar)
        exampleType = intent.getIntExtra("type", 0)

        setTheme()
        setContentView(layout)
        initViews()

        recyclerView!!.apply {
            setHasFixedSize(true)
            adapter = DummyListAdapter()
            layoutManager = LinearLayoutManager(this@DemoChildActivity)
        }
        Log.i("cccccccccccc","transitionToEnd")
//        motionLayout!!.transitionToEnd()

//        Handler().postDelayed({motionLayout!!.apply{
//            transitionToStart()
//        setTransitionListener(this@DemoChildActivity)
//        }}, 50)

    }

    private fun setTheme(){
        if (exampleType == ExampleTypes.FRAGMENT.ordinal && Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            window.apply {
                addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)
                addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
                addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
                navigationBarColor = ContextCompat.getColor(this@DemoChildActivity, R.color.black)
                /*decorView 是activity viewtree 的顶级view*/
                decorView.systemUiVisibility = 0
            }
        }else{
            setTheme(R.style.LightTheme)
        }
    }

    private fun initViews(){
        motionLayout = findViewById(R.id.motionLayout)
        recyclerView = findViewById(R.id.recyclerView)

//        if (layout == R.layout.collapsing_toolbar_2) {
//            titleTextView = findViewById(R.id.title)
//        }
    }


    override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {

    }

    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {

    }

}
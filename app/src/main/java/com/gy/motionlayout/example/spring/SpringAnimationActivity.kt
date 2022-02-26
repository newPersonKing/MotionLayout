package com.gy.motionlayout.example.spring

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import androidx.dynamicanimation.animation.SpringForce.DAMPING_RATIO_NO_BOUNCY
import com.gy.motionlayout.R
import kotlinx.android.synthetic.main.activity_spring_animation.*

// addUpdateListener addEndListener  removeEndListener
class SpringAnimationActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spring_animation)

        springTouch()

        springScale()
    }

    // 动画需要主动取消
    private fun springTouch(){
        var offsetX = 0f
        var offsetY = 0f
        iv_spring_test.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    offsetX = event.rawX
                    offsetY = event.rawY
                }
                MotionEvent.ACTION_MOVE -> {
                    iv_spring_test.translationX = event.rawX - offsetX
                    iv_spring_test.translationY = event.rawY - offsetY
                }
                MotionEvent.ACTION_UP -> {
                    SpringAnimation(iv_spring_test, DynamicAnimation.TRANSLATION_Y).apply {
                        spring = SpringForce().apply {
//                            dampingRatio = DAMPING_RATIO_NO_BOUNCY
//                            stiffness = SpringForce.STIFFNESS_VERY_LOW
                        }
                        // 动画最终结束位置 相对于起始点
                        animateToFinalPosition(0f)
                        // start() 也可以启动
                    }
                    SpringAnimation(iv_spring_test, DynamicAnimation.TRANSLATION_X).apply {
                        spring = SpringForce().apply {
//                            dampingRatio = DAMPING_RATIO_NO_BOUNCY
//                            stiffness = SpringForce.STIFFNESS_VERY_LOW
                        }
                        animateToFinalPosition(0f)
                    }

                    SpringAnimation(iv_spring_test, DynamicAnimation.ALPHA).apply {
                        spring = SpringForce().apply {
                            dampingRatio = 0f  //阻尼比。描述系统扰动后的振荡衰减过程
                            stiffness = SpringForce.STIFFNESS_HIGH // 即弹簧常数，物体的弹性系数。
                        }
                        addUpdateListener { animation, value, velocity ->
                            Log.i("ccccccccccccc","value===$value")
                        }
                        animateToFinalPosition(0.5f)
                    }

                    SpringAnimation(iv_spring_test, DynamicAnimation.ROTATION_X).apply {
                        spring = SpringForce().apply {
//                            dampingRatio = DAMPING_RATIO_NO_BOUNCY
//                            stiffness = SpringForce.STIFFNESS_VERY_LOW
                        }
                        animateToFinalPosition(45F)
                    }

                }
            }
            true
        }
    }

    private fun springScale(){
        var scaleFactor = 1f
        val  scaleGestureDetector = ScaleGestureDetector(this,
                object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
                    override fun onScale(detector: ScaleGestureDetector): Boolean {
                        scaleFactor *= detector.scaleFactor
                        iv_spring_scale.scaleX *= scaleFactor
                        iv_spring_scale.scaleY *= scaleFactor
                        return true
                    }
                })
        iv_spring_scale.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                SpringAnimation(iv_spring_scale, DynamicAnimation.SCALE_X).animateToFinalPosition(1f)
                SpringAnimation(iv_spring_scale, DynamicAnimation.SCALE_Y).animateToFinalPosition(1f)
            } else {
                scaleGestureDetector.onTouchEvent(event)
            }
            true
        }
    }

}
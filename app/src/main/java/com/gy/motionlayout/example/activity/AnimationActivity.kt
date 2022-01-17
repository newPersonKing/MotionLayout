package com.gy.motionlayout.example.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Carousel
import com.gy.motionlayout.R
import kotlinx.android.synthetic.main.activity_anime.*

class AnimationActivity : AppCompatActivity(){

    var images = intArrayOf(
            R.drawable.dm1,
            R.drawable.dm2,
            R.drawable.dm3,
            R.drawable.dm4,
            R.drawable.dm5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime)

        carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return 5
            }

            // 当每次动画 结束 都会回调这里
            // 这个view 对应的应该还是 start 布局中的view 只是他对应的数据源的index 跟之前不同了
            // 所以index 对应的是数据的index
            override fun populate(view: View?, index: Int) {
                Log.d("cccccccccccc", "index: " + index)
                Log.d("cccccccccccc", "currentIndex: " + carousel.currentIndex)
                if (view is ImageView) {
//                    view.setImageResource(images[index])
                    // val targetIndex = (carsoul.currentIndex + 2) % 5
                    val targetIndex = index
//                    val drawable = imageDrawable.getOrNull(targetIndex)
//                    if (drawable == null) {
//                        Glide.with(this@AnimeActivity)
//                                .load(images[targetIndex])
//                                .apply(RequestOptions().transform(BlurTransformation(20)))
//                                .into(object : SimpleTarget<Drawable>() {
//                                    override fun onResourceReady(
//                                            resource: Drawable,
//                                            transition: Transition<in Drawable>?
//                                    ) {
//                                        ivBackground.setImageDrawable(resource)
//                                        imageDrawable[targetIndex] = resource
//                                    }
//                                })
//                    } else {
//                        ivBackground.setImageDrawable(drawable)
//                    }
//                    ivBackground.setImageResource(images[targetIndex])
                }
            }

            override fun onNewItem(index: Int) {
                // called when an item is set
                Log.i("cccccccccccc","onNewItem")
            }
        })
    }




}
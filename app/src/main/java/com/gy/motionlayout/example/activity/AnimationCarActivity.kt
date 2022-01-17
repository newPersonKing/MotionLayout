package com.gy.motionlayout.example.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Carousel
import com.gy.motionlayout.R
import kotlinx.android.synthetic.main.activity_anime.*

class AnimationCarActivity : AppCompatActivity(){

    var images = intArrayOf(
            R.drawable.car1,
            R.drawable.car3,
            R.drawable.car4,
            R.drawable.car2
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_motion)

        carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return 4
            }

            override fun populate(view: View?, index: Int) {
                if(view is ImageView){
                    view.setImageResource(images[index])
                }
            }

            override fun onNewItem(index: Int) {
                // called when an item is set
            }
        })
    }

}
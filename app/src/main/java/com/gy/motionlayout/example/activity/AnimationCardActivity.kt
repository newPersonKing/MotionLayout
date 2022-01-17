package com.gy.motionlayout.example.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Carousel
import com.gy.motionlayout.R
import kotlinx.android.synthetic.main.activity_anime.*

class AnimationCardActivity : AppCompatActivity(){

    var images = intArrayOf(
            R.drawable.card1,
            R.drawable.card2,
            R.drawable.card3,
            R.drawable.card4,
            R.drawable.card5
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_motion)

        carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return 5
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
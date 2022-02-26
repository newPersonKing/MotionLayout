package com.gy.motionlayout.example.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.gy.motionlayout.R
import kotlinx.android.synthetic.main.activity_view_transition.*
import java.util.*


class ViewTransitionActivity : AppCompatActivity(){

    var random: Random = Random()
    val CONNECTED = 1
    val DISCONNECTED = 0
    var handler: Handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_transition)
        randomEventGenerator()
    }

    private fun randomEventGenerator() {
        handler.postDelayed({
            networkStatus(if (random.nextBoolean()) CONNECTED else DISCONNECTED)
            randomEventGenerator()
        }, 2000)
    }

    fun networkStatus(status: Int) {
        if (status == CONNECTED) {
            motionLayout.viewTransition(R.id.connect, face)
        } else {
            motionLayout.viewTransition(R.id.disconnect, face)
        }
    }

}
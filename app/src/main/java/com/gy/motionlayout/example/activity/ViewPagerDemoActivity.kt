package com.gy.motionlayout.example.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.gy.motionlayout.R
import com.wkk.motionlayoutdemo.fragment.ItemFragment
import kotlinx.android.synthetic.main.activity_view_pager_demo.*
import kotlinx.android.synthetic.main.viewpager_header.*

class ViewPagerDemoActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_demo)

        val avatars =
                arrayOf(R.drawable.avatar1, R.drawable.avatar2, R.drawable.avatar3, R.drawable.avatar4)

        val fragments = Array(avatars.size) { position ->
            ItemFragment.newInstance(avatars[position])
        }

        val titles = arrayOf("大雄","胖虎","小夫","静香")

        val adapter = object :
                FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            override fun getCount(): Int = fragments.size

            override fun getItem(position: Int): Fragment = fragments[position]

            override fun getPageTitle(position: Int): CharSequence = titles[position]
        }
        viewpager.adapter = adapter
        tabs.setupWithViewPager(viewpager)


        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
            ) {
                val root = findViewById<View>(R.id.motionLayout) as MotionLayout
                root.progress =
                        (position + positionOffset) / (adapter.count - 1)
            }

            override fun onPageSelected(position: Int) {}

            override fun onPageScrollStateChanged(state: Int) {}

        })

    }
}
package com.wkk.motionlayoutdemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.gy.motionlayout.R


private const val AVATAR_ID = "avatar_id"

class ItemFragment : Fragment(R.layout.fragment_item) {

     var avatarId: Int = R.drawable.avatar1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            avatarId = it.getInt(AVATAR_ID, R.drawable.avatar1)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val img = view.findViewById<ImageView>(R.id.imageView)
        img.setImageResource(avatarId)
    }



    companion object {
        @JvmStatic
        fun newInstance(@DrawableRes resId: Int) =
            ItemFragment().apply {
               avatarId = resId

            }
    }
}
package com.gy.motionlayout

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DemoAdapter(private val demoList: ArrayList<DemoAdapter.Demo>) : androidx.recyclerview.widget.RecyclerView.Adapter<DemoAdapter.ViewHolder>() {


    override fun getItemCount(): Int {
        return demoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item.text = demoList[position].item
        holder.layoutId = demoList[position].layoutId
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {

        val row = LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false) as ConstraintLayout;

        return ViewHolder(row)
    }


    class ViewHolder(val layout : ConstraintLayout) : androidx.recyclerview.widget.RecyclerView.ViewHolder(layout) {
        val item = layout.findViewById<TextView>(R.id.item)
        var layoutId = 0

        init {
            layout.setOnClickListener {
                val context = it.context as MainActivity
                context.start(layoutId)
            }
        }
    }

    data class Demo(val item:String,val layoutId:Int);

}
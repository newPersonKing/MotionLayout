package com.gy.motionlayout.example

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.gy.motionlayout.R

class MainAdapter(val data:Array<Demo>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.main_list_item,parent,false) as ConstraintLayout
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.layoutFileId = data[position].layout
        holder.activity = data[position].activity
        holder.exampleType = data[position].type
        holder.title.text = data[position].title
    }

    class ViewHolder(val layout:ConstraintLayout) : RecyclerView.ViewHolder(layout){

        var title = layout.findViewById<TextView> (R.id.titleTextView)
        var rootLayout = layout.findViewById<ConstraintLayout>(R.id.rootLayout)
        var layoutFileId = 0
        var activity : Class<*>?=null
        var exampleType : ExampleTypes? = null
        init {

            layout.setOnClickListener {
                val context  = it.context as DemoActivity
                /*activity?.let  意思是说 只有当activity不为空的时候 才会 继续执行*/
                activity?.let {
                    context.start(it, layoutFileId, exampleType, layoutPosition)
                }
            }

        }

    }

    data class Demo(val title: String, val type: ExampleTypes, val layout: Int = 0, val activity: Class<*> = DemoChildActivity::class.java) {
        constructor(title: String, type: ExampleTypes, activity: Class<*> = DemoChildActivity::class.java) : this(title, type, 0, activity)
    }

}
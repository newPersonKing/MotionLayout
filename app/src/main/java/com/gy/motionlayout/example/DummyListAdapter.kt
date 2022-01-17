package app.layout.motion.motionlayoutexample

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gy.motionlayout.R

class DummyListAdapter : androidx.recyclerview.widget.RecyclerView.Adapter<DummyListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DummyListAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.dummy_list_item, parent, false) as ConstraintLayout)
    }

    override fun getItemCount(): Int {
        return 15
    }

    override fun onBindViewHolder(holder: DummyListAdapter.ViewHolder, position: Int) {

    }

    class ViewHolder(val layout: ConstraintLayout) : androidx.recyclerview.widget.RecyclerView.ViewHolder(layout)

}
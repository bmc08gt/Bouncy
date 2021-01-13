package com.factor.example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.factor.bouncy.BouncyRecyclerView
import java.util.*

class Adapter : BouncyRecyclerView.Adapter()
{
    private val data = ArrayList<String>()

    init
    {
        for (i in 1..100) data.add("data: $i")
    }


    override fun onItemMoved(fromPosition: Int, toPosition: Int)
    {
        Collections.swap(data, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemSwipedToStart(viewHolder: ViewHolder?, positionOfItem: Int)
    {
        data[positionOfItem] += "\nswiped to left"
        notifyItemChanged(positionOfItem)
    }

    override fun onItemSwipedToEnd(viewHolder: ViewHolder?, positionOfItem: Int)
    {
        data[positionOfItem] += "\nswiped to right"
        notifyItemChanged(positionOfItem)
    }

    override fun onItemSelected(viewHolder: ViewHolder?)
    {

    }

    override fun onItemReleased(viewHolder: ViewHolder?)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        (holder as MyViewHolder).bindData(data[position])
    }

    override fun getItemCount(): Int
    {
        return data.size
    }

    internal class MyViewHolder(itemView: View) : ViewHolder(itemView)
    {
        fun bindData(data : String)
        {
            itemView.findViewById<TextView>(R.id.data_text).text = data
        }
    }


}

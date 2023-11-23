package com.example.demo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.databinding.ItemViewLinearVerticalBinding
import com.example.demo.entity.MyItem

class HomeViewAdapter(private val myItemList: List<MyItem>) : RecyclerView.Adapter<HomeViewAdapter.MyHolder>() {
    inner class MyHolder(private val view : ItemViewLinearVerticalBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(myItem: MyItem){
            view.itemMessage.text = myItem.content
            view.itemTitle.text = myItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val itemBinding = ItemViewLinearVerticalBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyHolder(itemBinding)
    }

    override fun getItemCount() = myItemList.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(myItemList[position])
    }
}
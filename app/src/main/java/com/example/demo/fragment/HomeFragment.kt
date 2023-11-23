package com.example.demo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo.HomeViewAdapter
import com.example.demo.R
import com.example.demo.databinding.FragmentHomeBinding
import com.example.demo.entity.MyItem

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val data = getData()
        for (i in 0 until data.size){
            println(data[i].title)
        }
        var bindView = FragmentHomeBinding.inflate(inflater,container,false)
        bindView.recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        bindView.recyclerView.adapter =  HomeViewAdapter(data)
        return bindView.root
    }

    fun getData() : List<MyItem>{
        var dataList = mutableListOf<MyItem>()
        for (i in 0..10){
            var MyItem  = MyItem(0,"title" + i,"msgmsgmsgmsgmsgmsg" + i)
            dataList.add(MyItem)
        }
        return dataList
    }

}
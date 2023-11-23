package com.example.demo.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.demo.TestServiceActivity

class SecondFragment : Fragment() {
    private lateinit var textView : TextView
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("SecondFragment","onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("SecondFragment","onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        textView = TextView(context)
        textView.text = "Second Fragment"
        textView.gravity = Gravity.CENTER

        Log.e("SecondFragment","onCreateView")
        return textView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view as TextView
        val int = arguments?.getInt("int_extra", 0)
        val string = arguments?.getString("string_extra")
        val content = arguments?.getString("content")
        textView.text = content

        textView.setOnClickListener {
            startActivity(Intent(context,TestServiceActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("SecondFragment","onStart")
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        Log.e("hide","${arguments?.getString("content")}$hidden")
    }

    override fun onResume() {
        super.onResume()
        Log.e("SecondFragment","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("SecondFragment","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("SecondFragment","onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("SecondFragment","onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("SecondFragment","onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("SecondFragment","onDetach")
    }
}
package com.example.demo

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.demo.fragment.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var textView:TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = TextView(this)
        textView.text = "Main"
        textView.gravity = Gravity.CENTER
        setContentView(textView)
        textView.setOnClickListener {
            //显式启动
            val intent = Intent(MainActivity@ this, SecondActivity::class.java)
            intent.putExtra("int_data",10)
            intent.putExtra("string_data","dd")
//            startActivity(intent)
            startActivityForResult(intent,1000)

            //隐式启动
//            val intent = Intent()
//            intent.action = "SECOND ACTIVITY"
//            intent.addCategory("SECOND CATEGORY")
//            intent.putExtra("int_data",10)
//            intent.putExtra("string_data","dd")
//            startActivity(intent)

            //打电话
//            val uri =  Uri.parse("tel:10086")
//            var intent = Intent(Intent.ACTION_DIAL,uri)
//            startActivity(intent)
        }
        Log.e("SecondActivity: ", "onCreate")


//        val homeFragment = HomeFragment()
//        supportFragmentManager.beginTransaction().add(R.id.my_fragment,homeFragment).commitAllowingStateLoss()
    }
    override fun onStart() {
        super.onStart()
        Log.e("MainActivity:", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity:", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MainActivity: ", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity: ", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MainActivity: ", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("MainActivity: ", "onRestart")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000 && resultCode == Activity.RESULT_OK && data != null){
            val stringExtra = data.getStringExtra("back_string")
            val intExtra = data.getIntExtra("back_int",0)
            textView.text = stringExtra + intExtra
        }
    }
}
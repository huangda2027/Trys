package com.example.demo

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.databinding.ActivityTestServiceBinding
import com.example.demo.service.TestService1
import com.example.demo.service.TestService2

class TestServiceActivity : AppCompatActivity() {
    private lateinit var connection: ServiceConnection
    private lateinit var myBinder: TestService2.MyBinder
    private lateinit var binding: ActivityTestServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        connection = object : ServiceConnection{
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                Log.e("TestService2"," onService--Connected")
                myBinder = service as TestService2.MyBinder
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                Log.e("TestService2"," onService--DisConnected")
            }

        }

        val intent = Intent(this, TestService2::class.java)
        bindService(intent,connection,Context.BIND_AUTO_CREATE)

        binding.startService.setOnClickListener {
//            val intent = Intent(this,TestService1::class.java)
//            startService(intent)
//            Log.e("MSG","start")

//            bindService类
            Log.e("TestService2"," TestService2-${myBinder.getCount()}")
        }
        binding.stopService.setOnClickListener {
//            val intent = Intent(this,TestService1::class.java)
//            stopService(intent)
//            Log.e("MSG","stop")
            unbindService(connection)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection!!)
    }
}
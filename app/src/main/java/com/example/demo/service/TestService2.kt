package com.example.demo.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class TestService2 : Service() {
    private val TAG = "TestService2"
    private var count = 0
    private var quit = false

    private val binder : MyBinder = MyBinder()

    inner class MyBinder : Binder(){
        fun getCount():Int{
            return count
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.e(TAG," onBind")
        return binder
    }

    override fun onCreate() {
        Log.e(TAG," onCreate")
        super.onCreate()
        Thread(Runnable {
            while (true){
                if (quit) break
                Thread.sleep(1000)
                count++
            }

        }).start()
    }
    override fun onUnbind(intent: Intent?): Boolean {
        Log.e(TAG," onUnBind")
        quit = true
        return true
    }

    override fun onDestroy() {
        Log.e(TAG,"onDestroy")
        super.onDestroy()
    }
}
package com.example.demo

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.demo.databinding.ActivitySecondBinding
import com.example.demo.fragment.HomeFragment
import com.example.demo.fragment.SecondFragment
import com.google.android.material.button.MaterialButton

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        这种写法不行
//        setContentView(R.layout.activity_second)

        binding.toggleGroup.addOnButtonCheckedListener {
                group,checkedId,isChecked ->
            val childCount = group.childCount
            var selected = 0
            for (i in 0 until childCount) {
                val button = group.getChildAt(i) as MaterialButton
                if (button.id == checkedId){
                    selected = i
                    button.setTextColor(Color.RED)
                    button.iconTint = ColorStateList.valueOf(Color.RED)
                }else{
                    button.setTextColor(Color.BLACK)
                    button.iconTint = ColorStateList.valueOf(Color.BLACK)
                }
            }
            Log.e("TAG", "Message: $checkedId")
            switchFragment(selected)
        }
        binding.toggleGroup.check(R.id.tab1)

//        val bundle = Bundle()
//        bundle.putInt("int_extra",11)
//        bundle.putString("string_extra","msg")
//        val fragment : SecondFragment = SecondFragment()
//        fragment.arguments = bundle
//        supportFragmentManager.beginTransaction().add(R.id.container,fragment).commitAllowingStateLoss()

//
//        val textView = TextView(this)
//        val stringExtra = intent.getStringExtra("string_data")
//        val intExtra = intent.getIntExtra("int_data",0)
//        textView.text = "Second $stringExtra -- $intExtra"
//        textView.gravity = Gravity.CENTER
//        setContentView(textView)
//
//
//        textView.setOnClickListener {
////            val newIntent = Intent(SecondActivity@ this, MainActivity::class.java)
////            startActivity(newIntent)
//            val resultIntent = Intent()
//            resultIntent.putExtra("back_string","datadata")
//            resultIntent.putExtra("back_int",111)
//            setResult(Activity.RESULT_OK,resultIntent)
//            finish()
//
//        }
//        Log.e("SecondActivity: ", "onCreate")
    }
    private var tab1Fragment : SecondFragment?=null
    private var tab2Fragment : HomeFragment?=null
    private var tab3Fragment : SecondFragment?=null
    private var showFragment : Fragment?=null
    private fun switchFragment(selectIndex : Int) {
        val bundle = Bundle()

        val myFragment = when (selectIndex) {
            0 -> {
                if (tab1Fragment == null) {
                    tab1Fragment = SecondFragment()
                    bundle.putString("content", "tab1--Content")
                    tab1Fragment!!.arguments = bundle
                }
                tab1Fragment
            }

            1 -> {
                if (tab2Fragment == null) {
                    tab2Fragment = HomeFragment()
                    bundle.putString("content", "tab2--Content")
                    tab2Fragment!!.arguments = bundle
                }
                tab2Fragment
            }

            2 -> {
                if (tab3Fragment == null) {
                    tab3Fragment = SecondFragment()
                    bundle.putString("content", "tab3--Content")
                    tab3Fragment!!.arguments = bundle
                }
                tab3Fragment
            }

            else -> {
                throw IllegalStateException("not expeted")
            }
        }?:return

        val beginTransaction = supportFragmentManager.beginTransaction()
        if (!myFragment.isAdded){
            beginTransaction.add(R.id.container,myFragment)
        }
        beginTransaction.show(myFragment)
        if (showFragment != null) beginTransaction.hide(showFragment!!)
        showFragment = myFragment
        beginTransaction.commitAllowingStateLoss()

    }

    override fun onStart() {
        super.onStart()
        Log.e("SecondActivity:", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("SecondActivity:", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("SecondActivity: ", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("SecondActivity: ", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("SecondActivity: ", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("SecondActivity: ", "onRestart")
    }
}
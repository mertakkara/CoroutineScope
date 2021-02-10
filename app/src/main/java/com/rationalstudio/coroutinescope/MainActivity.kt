package com.rationalstudio.coroutinescope

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    val TAG = "MyTag"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener{
            lifecycleScope.launch{
                while (true){
                    delay(2000L)
                    Log.d(TAG,"Still runninng")
                }
            }
            GlobalScope.launch {
                delay(5000L)
                Intent(this@MainActivity,SecondActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }

    }
}
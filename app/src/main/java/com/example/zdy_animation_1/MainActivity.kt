package com.example.zdy_animation_1

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var isStart = true
        start.setOnClickListener(){
            if (isStart){
                loading.start()
            }else{
                loading.stop()
            }
            isStart = !isStart
        }


        jump.setOnClickListener(){
            Intent().also {
                it.setClass(this,Main2Activity::class.java)
                startActivity(it)
            }
        }
    }
}

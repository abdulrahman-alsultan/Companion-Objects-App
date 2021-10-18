package com.example.companionobjectsapp

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class Background{
    companion object{

        fun changeBackground(ctx: ConstraintLayout){
            if(DayOrNight.day){
                ctx.setBackgroundResource(R.drawable.day)
            }else{
                ctx.setBackgroundResource(R.drawable.night)
            }
        }
    }
}

class DayOrNight{
    companion object{
        var day = false
        var night = false
    }
}




class MainActivity : AppCompatActivity() {

    lateinit var constraint: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<TextView>(R.id.et_day_or_night)
        val btn = findViewById<Button>(R.id.btn_change_background)
        constraint = findViewById(R.id.constrain)

        btn.setOnClickListener {
            val tmp = input.text.toString()
            if(tmp.isNotEmpty()){
                if (tmp == "Day"){
                    DayOrNight.day = true
                    DayOrNight.night = false
                    Background.changeBackground(constraint)
                }
                else if(tmp == "Night"){
                    DayOrNight.day = false
                    DayOrNight.night = true
                    Background.changeBackground(constraint)
                }
                else
                    Toast.makeText(this, "Make sure you enter Day or Night", Toast.LENGTH_LONG).show()
            }
        }


    }
}
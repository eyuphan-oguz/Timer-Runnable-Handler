package com.eyuphanoguz.handlerrunnable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var number = 0
    var runnable : Runnable = Runnable{}
    var handler : Handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun startTimer(view:View){
        var customTextView = findViewById<TextView>(R.id.textView)


        runnable= object:Runnable{
            override fun run() {
                number +=1
                customTextView.text="Sayaç: ${number}"
                handler.postDelayed(runnable,1000)
            }

        }
        handler.post(runnable)
    }

    fun stopTimer(view:View){
        var customTextView = findViewById<TextView>(R.id.textView)
        handler.removeCallbacks(runnable)
        number=0
        customTextView.text ="Sayaç : 0"

    }
}
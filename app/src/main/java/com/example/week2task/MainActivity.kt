package com.example.week2task

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var changingText:TextView
    private lateinit var textView: TextView
    val handler = Handler(Looper.getMainLooper())
    var portraitCount = 0
    var landscapeCount = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changingText = findViewById(R.id.textView1)
        textView = findViewById(R.id.textView2)


        if (savedInstanceState != null){
            portraitCount = savedInstanceState.getInt("Portrait")
            landscapeCount = savedInstanceState.getInt("Landscape")
        }

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            landscapeCount++
            textView.text = "Landscape " + landscapeCount
        } else  {
            portraitCount++
            textView.text = "Portrait " + portraitCount
        }


        val actionBar = supportActionBar
        actionBar!!.title = "MY FIRST ACTIVITY"

        var buttonSecondActivity: Button = findViewById(R.id.impButton)
        buttonSecondActivity.setOnClickListener() {
            val intentToSecondActivity = Intent(this, SecondActivity::class.java)
            startActivity(intentToSecondActivity)
        }

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(Runnable {
            changingText.text = "The onCreate() event"
        }, 4000)
        }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("Portrait", portraitCount)
        outState.putInt("Landscape", landscapeCount)
    }

    override fun onStart() {
        super.onStart()
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(Runnable {
            changingText.text = "The onStart() event"
        }, 4000)
    }

    override fun onResume() {
        super.onResume()
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(Runnable {
            changingText.text = "The onResume() event"
        }, 4000)
    }

    override fun onPause() {
        super.onPause()
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(Runnable {
            changingText.text = "The onPause() event"
        }, 4000)
    }

    override fun onStop() {
        super.onStop()
        changingText.text = "The onStop() event"
    }

    override fun onRestart() {
        super.onRestart()
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(Runnable {
            changingText.text = "The onRestart() event"
        }, 4000)
    }

    override fun onDestroy() {
        super.onDestroy()
        changingText.text = "The onDestroy() event"
    }




}

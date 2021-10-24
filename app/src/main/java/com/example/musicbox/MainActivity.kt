package com.example.musicbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun click(v: View) {
        val i: Intent = Intent(this, MediaServic::class.java);
        if (v.getId() == R.id.start) {
            startService(i);
        } else {
            stopService(i);
        }
    }

}
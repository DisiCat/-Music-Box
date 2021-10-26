package com.example.musicbox

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context, intent: Intent) {


        Toast.makeText(
            context, "Обнаружено сообщение: " +
                    "Action: ${intent.getStringExtra("data")}",
            Toast.LENGTH_LONG
        ).show()
    }
}


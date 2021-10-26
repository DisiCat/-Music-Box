package com.example.musicbox

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context, intent: Intent) {
        StringBuilder().apply {
            append("Action: ${intent.action}\n")
            append("URI: ${intent.toUri(Intent.URI_INTENT_SCHEME)}\n")
            toString().also {
                Toast.makeText(context, "Обнаружено сообщение: " +
                        this,
                    Toast.LENGTH_LONG).show()
            }}

    }


}
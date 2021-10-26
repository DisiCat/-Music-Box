package com.example.musicbox

import android.annotation.SuppressLint
import android.app.Notification
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.app.NotificationCompat

import android.app.NotificationManager

import android.app.NotificationChannel

import android.os.Build




class MainActivity : AppCompatActivity() {


    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: LinearLayout = findViewById(R.id.notific)
        button.setOnClickListener {


            val notificationManager  = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val NOTIFICATION_CHANNEL_ID = "my_channel_id_01"

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notificationChannel = NotificationChannel(
                    NOTIFICATION_CHANNEL_ID,
                    "My Notifications",
                    NotificationManager.IMPORTANCE_MAX
                )

                // Configure the notification channel.
                notificationChannel.description = "Я Усталь:С "
                notificationChannel.enableLights(true)
                notificationChannel.vibrationPattern = longArrayOf(0, 1000, 500, 1000)
                notificationChannel.enableVibration(true)
                notificationManager.createNotificationChannel(notificationChannel)
            }


            val notificationBuilder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)

            notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setTicker("Hearty365") //     .setPriority(Notification.PRIORITY_MAX)
                .setContentTitle("Я усталь")
                .setContentText("ничего нового")
                .setContentInfo("Info")

            notificationManager.notify( /*notification id*/1, notificationBuilder.build())


        }
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

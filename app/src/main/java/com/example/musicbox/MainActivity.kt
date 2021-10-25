package com.example.musicbox

import android.app.Notification
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    companion object {
        const val NOTIFICATION_ID = 101
        const val CHANNEL_ID = "channelID"
        const val IDENTIFIER_STRING = "com.example.musicbox"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: LinearLayout = findViewById(R.id.notific)
        button.setOnClickListener {
            // Создаём уведомление
            val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_notification_important_24)
                .setContentTitle("Напоминание")
                .setContentText("Ничего не произошло")
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)


            with(NotificationManagerCompat.from(this)) {
                notify(NOTIFICATION_ID, builder.build()) // посылаем уведомление
            }

// Создаем сообщение с помощью Broadcast и передаем текст "у вас новое уведомление"
            val intent = Intent()
            intent.setAction(IDENTIFIER_STRING)
            intent.putExtra("text","у вас новое уведомление")
            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
            sendBroadcast(intent)

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

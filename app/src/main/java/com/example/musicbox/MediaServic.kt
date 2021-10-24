package com.example.musicbox

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder


class MediaServic : Service() {

    var ambientMediaPlayer: MediaPlayer? = null
    override fun onBind(intent: Intent?): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onCreate() {
        ambientMediaPlayer = MediaPlayer.create(this, R.raw.music)
        ambientMediaPlayer!!.isLooping = true
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        ambientMediaPlayer!!.start()
        return START_STICKY
    }

    override fun onDestroy() {
        ambientMediaPlayer!!.stop()
    }
}
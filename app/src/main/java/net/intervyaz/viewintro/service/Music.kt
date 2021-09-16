package net.intervyaz.viewintro.service

import android.app.Service
import android.content.ContentValues
import android.content.Intent
import android.media.MediaPlayer
import android.os.Handler
import android.os.IBinder
import android.util.Log
import net.intervyaz.viewintro.R
import java.util.*

class Music : Service() {

    // Музыка в фоне
    private var mediaPlayer: MediaPlayer? = null

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.music_back)
        mediaPlayer?.isLooping
        mediaPlayer?.start()
    }

    // Команда "старт"
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        return super.onStartCommand(intent, flags, startId)
    }

    // Команда "стоп"
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()

    }
}
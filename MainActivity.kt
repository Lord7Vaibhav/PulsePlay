package com.pulseplay.app

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webview)
        val btnPlay = findViewById<ImageButton>(R.id.btn_play)
        val tvSong = findViewById<TextView>(R.id.tv_song)
        val tvArtist = findViewById<TextView>(R.id.tv_artist)

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://open.spotify.com")

        tvSong.text = "Blinding Lights"
        tvArtist.text = "The Weeknd"

        btnPlay.setOnClickListener {
            isPlaying = !isPlaying
            btnPlay.setImageResource(
                if (isPlaying)
                    android.R.drawable.ic_media_pause
                else
                    android.R.drawable.ic_media_play
            )
            Toast.makeText(
                this,
                if (isPlaying) "Playing..." else "Paused",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

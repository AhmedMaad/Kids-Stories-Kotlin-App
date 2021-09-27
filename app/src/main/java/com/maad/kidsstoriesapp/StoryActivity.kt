package com.maad.kidsstoriesapp

import android.content.Context
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class StoryActivity : AppCompatActivity() {

    lateinit var media: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        val actionBarTitle = intent.getStringExtra("title")
        val sound = intent.getIntExtra("sound", -1)
        val story = intent.getStringExtra("story")
        val picture = intent.getIntExtra("picture", R.drawable.ic_broken_image)

        setTitle(actionBarTitle)

        media = MediaPlayer.create(this, sound)
        media.start()

        val storyIV: ImageView = findViewById(R.id.iv)
        storyIV.setImageResource(picture)

        val textPreference = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val textSize = textPreference.getInt("size", 24)

        val storyTV: TextView = findViewById(R.id.tv)
        storyTV.setText(story)
        storyTV.setTextSize(textSize.toFloat())

    }

    override fun onPause() {
        super.onPause()
        media.release()
    }

}
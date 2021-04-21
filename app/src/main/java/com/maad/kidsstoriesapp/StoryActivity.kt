package com.maad.kidsstoriesapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class StoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        val actionBarTitle = intent.getStringExtra("title")
        val story = intent.getStringExtra("story")
        val picture = intent.getIntExtra("picture", R.drawable.ic_broken_image)

        setTitle(actionBarTitle)

        val storyIV: ImageView = findViewById(R.id.iv)
        storyIV.setImageResource(picture)

        val textPreference = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val textSize = textPreference.getInt("size", 16)

        val storyTV: TextView = findViewById(R.id.tv)
        storyTV.setText(story)
        storyTV.setTextSize(textSize.toFloat())

    }

}
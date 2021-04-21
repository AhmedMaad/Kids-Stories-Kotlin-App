package com.maad.kidsstoriesapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        setTitle("Settings")

        val rg: RadioGroup = findViewById(R.id.rg)
        rg.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.rb_small -> saveTextSize(12)
                R.id.rb_medium -> saveTextSize(16)
                R.id.rb_large -> saveTextSize(20)
            }
        })

    }

    private fun saveTextSize(size: Int){
        val editor = getSharedPreferences("settings", Context.MODE_PRIVATE).edit()
        editor.putInt("size", size)
        editor.apply()
    }

}
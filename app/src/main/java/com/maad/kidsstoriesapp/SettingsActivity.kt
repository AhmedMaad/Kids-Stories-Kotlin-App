package com.maad.kidsstoriesapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.Toast

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        setTitle("Settings")

        val rg: RadioGroup = findViewById(R.id.rg)

        val prefs = getSharedPreferences("settings", MODE_PRIVATE);
        val savedSize = prefs.getInt("size", 24)
        when (savedSize) {
            18 -> rg.check(R.id.rb_small)
            24 -> rg.check(R.id.rb_medium)
            32 -> rg.check(R.id.rb_large)
        }

        rg.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rb_small -> saveTextSize(18)
                R.id.rb_medium -> saveTextSize(24)
                R.id.rb_large -> saveTextSize(32)
            }
        }

    }

    private fun saveTextSize(size: Int) {
        val editor = getSharedPreferences("settings", Context.MODE_PRIVATE).edit()
        editor.putInt("size", size)
        editor.apply()
        Toast.makeText(this, "Size Changed Successfully", Toast.LENGTH_SHORT).show()
    }

}
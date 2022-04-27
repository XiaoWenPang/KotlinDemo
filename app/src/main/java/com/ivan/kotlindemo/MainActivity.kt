package com.ivan.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = find<TextView>(R.id.text)
        R.id.text.onClick(this) {
            textView.text = "Kotlin Extension"
        }
    }
}
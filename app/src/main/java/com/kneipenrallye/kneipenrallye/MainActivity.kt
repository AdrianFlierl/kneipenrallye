package com.kneipenrallye.kneipenrallye

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, barlist::class.java).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, "message");
        }
        startActivity(intent);
    }


    fun openBarlist(view: View) {
        val intent = Intent(this, barlist::class.java).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, "message");
        }
        startActivity(intent);
    }
}

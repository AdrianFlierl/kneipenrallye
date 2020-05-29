package com.kneipenrallye.kneipenrallye

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btn_account.setOnClickListener {
            val intent = Intent(this, Account::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "message");
            }
            startActivity(intent);
        }


        btn_main_reg.setOnClickListener {
            val intent = Intent(this, Registration::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "message");
            }
            startActivity(intent);
        }


        btn_barlist.setOnClickListener {
            val intent = Intent(this, barlist::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "message");
            }
            startActivity(intent);
        }
    }
}



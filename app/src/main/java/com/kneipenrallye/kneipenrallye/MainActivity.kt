package com.kneipenrallye.kneipenrallye

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        News.globalContext = this.applicationContext


        btn_livemap.setOnClickListener{
            val intent = Intent(this, MapsActivity::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "message");
            }
            startActivity(intent);
        }

        btn_account.setOnClickListener {
            val intent = Intent(this, AccountActivity::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "message");
            }
            startActivity(intent);
        }


        btn_main_reg.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "message");
            }
            startActivity(intent);
        }


        btn_barlist.setOnClickListener {
            val intent = Intent(this, BarlistActivity::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "message");
            }
            startActivity(intent);
        }

        btn_notification.setOnClickListener {
            // Get token
            // [START retrieve_current_token]
            FirebaseInstanceId.getInstance().instanceId
                .addOnCompleteListener(OnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        Log.w("TAG", "getInstanceId failed", task.exception)
                        return@OnCompleteListener
                    }

                    // Get new Instance ID token
                    val token = task.result?.token

                    // Log and toast
                    //val msg = getString(token)
                    Log.d("TAG", token)
                    Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
                })
            // [END retrieve_current_token]
        }


        btn_test.setOnClickListener {

            val intent = Intent(this, News::class.java).apply {
                putExtra("TITLE", "my custom title");
                putExtra("MESSAGE", "my custom message");
            }
            startActivity(intent);
        }

    }
}



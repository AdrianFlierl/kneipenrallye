package com.kneipenrallye.kneipenrallye

import android.R.attr.name
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class Account : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    //var user2 : FirebaseUser? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance();
        val currentUser = auth.currentUser

        auth.signInAnonymously()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("AccountActivity", "signInAnonymously:success")
                    Toast.makeText(baseContext, "Authentication success.",
                        Toast.LENGTH_SHORT).show()
                    val user = auth.currentUser

                    updateUIAccount(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("AccountActivity", "signInAnonymously:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUIAccount(null)
                }

                // ...
            }

    }

    fun updateUIAccount(user: FirebaseUser?) {

        val textView: TextView = findViewById(R.id.txt_example) as TextView

        if(user != null)
        {
            textView.text = user?.uid.toString()

        }
        else
        {
            textView.text = "unknown user"
        }

    }

}

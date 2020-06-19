package com.kneipenrallye.kneipenrallye

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)


        // TODO: Auto generate random funny username

        val spinner: Spinner = findViewById(R.id.spin_faculties)
        ArrayAdapter.createFromResource(
            this,
            R.array.faculties_de,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        spinner.setSelection(5)

        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = auth.currentUser
//        updateUI(currentUser)
//
//
//        // Firebase authentication
//        auth = Firebase.auth
//        FirebaseAuth.getInstance().createUserWithEmailAndPassword("kneipentash@trash-mail.com", "secure")
//            .addOnCompleteListener()

        btn_main_registration.setOnClickListener {

            val posFaculti = spin_faculties.selectedItemPosition
            val username = txt_username.text.toString()
            Log.d("RegistrationActivity", "Username is:" + username)

            if(username.isEmpty())
            {
                Toast.makeText(this, "Please enter Username", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            Toast.makeText(applicationContext, posFaculti.toString(), Toast.LENGTH_SHORT).show()
        }
    }

}

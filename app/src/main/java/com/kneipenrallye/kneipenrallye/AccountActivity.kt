package com.kneipenrallye.kneipenrallye

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_account.*


class AccountActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    lateinit var myList: MutableList<MyAccount>

    //var user2 : FirebaseUser? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance();
        database = Firebase.database.reference

        myList = mutableListOf()

        val currentUser = auth.currentUser

        auth.signInAnonymously()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("AccountActivity", "signInAnonymously:success")
                    Toast.makeText(baseContext, "Authentication success.",
                        Toast.LENGTH_SHORT).show()
                    val user = auth.currentUser

                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("AccountActivity", "signInAnonymously:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUIAccount(null)
                }

                // ...
            }

        btn_send.setOnClickListener {
            // Write a message to the database

            // Write a message to the database
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference("message")
            val msg = txt_input.text


            if(msg.isNotEmpty())
            {
                val myAccountId = myRef.push().key

                val element = MyAccount(myAccountId, auth.uid.toString(), msg.toString())

                if (myAccountId != null) {
                    myRef.child(myAccountId).setValue(element).addOnCompleteListener {
                        Toast.makeText(applicationContext, "Saved Successfully", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        btn_receive.setOnClickListener {
            // Read from the database
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference("message")

            // Read from the database
            myRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    if(dataSnapshot!!.exists())
                    {
                        myList.clear()
                        for (m in dataSnapshot.children) {
                            val i = m.getValue(MyAccount::class.java)
                            if(i != null)
                            {
                                lbl_output.text = i?.input.toString()
                            }

                        }
                        //val value = dataSnapshot.getValue(String::class.java)
                        //Log.d("FragmentActivity.TAG", "Value is: $value")

                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Failed to read value
                    Log.w(
                        "FragmentActivity.TAG,",
                        "Failed to read value.",
                        error.toException()
                    )
                    lbl_output.text = "failed"
                }
            })
        }

    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        val strUid = currentUser?.uid.toString()
        txt_example.text = strUid
    }

//    fun updateUIAccount(user: FirebaseUser?) {
//
//        val textView: TextView = findViewById(R.id.txt_example) as TextView
//
//        if(user != null)
//        {
//            textView.text = user?.uid.toString()
//
//        }
//        else
//        {
//            textView.text = "unknown user"
//        }
//
//    }



}

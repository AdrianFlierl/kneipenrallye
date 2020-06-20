package com.kneipenrallye.kneipenrallye

import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_news.*

class News : AppCompatActivity() {

    companion object {
        var globaleTitle = "global Title";
        var globalMessage = "global Message"
        var globalContext : Context? = null;

        fun addToList(title : String, body: String)
        {
            globaleTitle = title;
            globalMessage = body;
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        setLabel()

        val str_title = intent.getStringExtra("TITLE")
        val str_message = intent.getStringExtra("MESSAGE")

        if(str_title != null && str_message != null) {
            myAlertFunction(str_title, str_message);
        }
    }

    fun setLabel()
    {
        lbl_title.text = globaleTitle;
        lbl_message.text = globalMessage;
    }


    fun myAlertFunction(title : String, body : String)
    {
        val alertDialog = AlertDialog.Builder(this).create()
        alertDialog.setTitle(title)
        alertDialog.setMessage(body)
        alertDialog.setButton(
            AlertDialog.BUTTON_NEUTRAL, "OK"
        ) { dialog, which -> dialog.dismiss() }
        alertDialog.show()
    }
}

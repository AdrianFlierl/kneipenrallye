package com.kneipenrallye.kneipenrallye

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import com.pixplicity.easyprefs.library.Prefs

import kotlinx.android.synthetic.main.settings_activity.*

class SettingsActivity : AppCompatActivity() {

    companion object{
        var USERNAME = "USERNAME"
        var PASSWORD = "PASSWORD"
        var PUSH_NOTIFICATION = "PUSH_NOTIFICATION"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)


        btn_load.setOnClickListener {
            txt_username.setText(Prefs.getString(USERNAME, "UNKNOWN"))
            txt_pwd.setText(Prefs.getString(PASSWORD, "UNKNOWN"))
            cb_push_notification.isChecked = Prefs.getBoolean(PUSH_NOTIFICATION, true)
        }

        btn_save.setOnClickListener {
            Prefs.putString(USERNAME, txt_username.text.toString());
            Prefs.putString(PASSWORD, txt_pwd.text.toString());
            Prefs.putBoolean(PUSH_NOTIFICATION, cb_push_notification.isChecked)
        }
    }

}
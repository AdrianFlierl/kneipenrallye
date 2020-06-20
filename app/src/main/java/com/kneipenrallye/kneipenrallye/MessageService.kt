package com.kneipenrallye.kneipenrallye

import android.R
import android.app.AlertDialog
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.net.Uri
import android.provider.AlarmClock
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.kneipenrallye.kneipenrallye.News

class MessageService : FirebaseMessagingService()
{
    override fun onNewToken(token: String) {
        Log.d("TAG", "Refreshed token: $token")

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        //sendRegistrationToServer(token)
    }


    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d("TAG", "From: ${remoteMessage.from}")

        // Check if message contains a data payload.
        if (remoteMessage.data.isNotEmpty()) {
            Log.d("TAG", "Message data payload: ${remoteMessage.data}")

            //sendNotification(remoteMessage.getData().get("title"),remoteMessage.getData().get("body"))
            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use WorkManager.

                //scheduleJob()
            } else {
                // Handle message within 10 seconds

                //handleNow()
            }
        }

        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            Log.d("TAG", "Message Notification Body: ${it.body}")
        }

        val title: String? = remoteMessage.notification!!.title.toString()
        val message: String? = remoteMessage.notification!!.body.toString()
        if (title != null && message != null) {

            if(News.globalContext != null) {
                val intent = Intent(News.globalContext, News::class.java).apply {
                    putExtra("TITLE", title);
                    putExtra("MESSAGE", message);
                }
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                News.globalContext?.startActivity(intent)
            }
            else {
                News.globaleTitle = title;
                News.globalMessage = message;
            }

            // THIS IS NOT NULL AND MAKE A EXCEPTION!!!!!!!!!!!!!!!
            // myAlertFunction(title, message)
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    };
}
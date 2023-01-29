package com.example.notifications.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

//  broadcast receivers are used to receive a message from the android system itself
class MyReceiver : BroadcastReceiver() {

    //  Receiving the message from our action button
    override fun onReceive(context: Context?, intent: Intent?) {

        val message = intent?.getStringExtra("MESSAGE")

        message?.let {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

    }
}
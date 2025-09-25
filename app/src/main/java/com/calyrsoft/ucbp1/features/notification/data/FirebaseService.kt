package com.calyrsoft.ucbp1.features.notification.data

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
class FirebaseService: FirebaseMessagingService() {
    companion object {
        val TAG = FirebaseService::class.java.simpleName
    }

    override fun onMessageReceived(message: RemoteMessage) {
        Log.d(TAG, "From: " + message.from)
        if (message.data.size > 0) {
            Log.d(TAG, "Message data payload: " + message.data)
        }
        if (message.notification != null) {
            Log.d(TAG, "Message Notification Body: " + message.notification!!.body)
        }

    }
}
package com.icapps.rnpushnotifications.service

import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.icapps.rnpushnotifications.bridge.js.RNJsBridge
import com.icapps.rnpushnotifications.model.Notification
import com.icapps.rnpushnotifications.persitance.SharedPrefs
import com.icapps.rnpushnotifications.util.NotificationUtil
import org.json.JSONObject

/**
 * @author Koen Van Looveren
 */
class FCMService : FirebaseMessagingService() {

    companion object {
        private const val MESSAGE = "hiddenmessage"
        private const val MESSAGE_CONTENT = "message"
        private const val MESSAGE_TITLE = "title"
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)
        Log.d("FCMService", "Message received")

        val data = remoteMessage?.data
        val json = data?.get(MESSAGE)
        if (json == null) {
            Log.d("FCMService", "hiddenMessage is not added the notification, could not create a notification")
            return
        }

        val jsonObject = JSONObject(json)
        val jsBridge = RNJsBridge(applicationContext as ReactApplicationContext)

        val title = jsonObject.getString(MESSAGE_TITLE)
        val content = jsonObject.getString(MESSAGE_CONTENT)
        if (title == null && content == null) {
            Log.d("FCMService", "The json could not be parsed")
            return
        }
        val notification = Notification.Builder(title, content).build()
        val background = (applicationContext as ReactApplicationContext).hasActiveCatalystInstance()
        val notificationId = NotificationUtil.createNotification(applicationContext, background, notification)
        jsBridge.notifyJsNewNotification(jsonObject, notificationId)
    }

    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        SharedPrefs(applicationContext).saveFirebaseToken(token)
        token?.let {
            val jsBridge = RNJsBridge(applicationContext as ReactApplicationContext)
            jsBridge.notifyJsNewToken(token)
        }
    }
}
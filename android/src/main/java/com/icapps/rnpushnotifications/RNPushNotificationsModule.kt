package com.icapps.rnpushnotifications

import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.InstanceIdResult
import com.icapps.rnpushnotifications.model.Notification
import com.icapps.rnpushnotifications.persitance.SharedPrefs
import com.icapps.rnpushnotifications.util.NotificationUtil

/**
 * @author Koen Van Looveren
 */
class RNPushNotificationsModule internal constructor(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    companion object {
        private const val NAME = "RNPushNotifications"
    }

    private val sharedPrefs = SharedPrefs(reactContext)

    @ReactMethod
    fun getFirebaseToken(promise: Promise) {
        val oldToken = sharedPrefs.getFirebaseToken()
        oldToken?.let {
            promise.resolve(it)
            return
        }
        FirebaseInstanceId.getInstance()
                .instanceId
                .addOnCompleteListener(OnCompleteListener<InstanceIdResult> { task ->
                    if (!task.isSuccessful) {
                        promise.reject("", "Could not retrieve the FCM token.")
                        return@OnCompleteListener
                    }
                    val token = task.result?.token
                    sharedPrefs.saveFirebaseToken(token)
                    promise.resolve(token)
                })
    }

    @ReactMethod
    fun createNotification(title: String?, content: String?, promise: Promise) {
        if (title == null || content == null) {
            promise.reject("local-notification", "Could not create a local notification. Enter title and content")
            return
        }

        val notification = Notification.Builder(title, content).build()

        val id = NotificationUtil.createNotification(reactApplicationContext, reactApplicationContext.hasActiveCatalystInstance(), notification)
        if (id == null) {
            promise.reject("local-notification", "Could not create a notification. No activity to link the notification to")
        } else {
            promise.resolve(id)
        }
    }

    override fun getName(): String {
        return NAME
    }
}
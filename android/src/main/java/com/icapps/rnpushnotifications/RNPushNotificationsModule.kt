package com.icapps.rnpushnotifications

import android.util.Log

import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

/**
 * @author Koen Van Looveren
 */
class RNPushNotificationsModule internal constructor(private val reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    @ReactMethod
    fun getFirebaseToken(promise: Promise) {
        promise.resolve("real-token")
        Log.d(NAME, "token provided")
    }

    override fun getName(): String {
        return NAME
    }

    companion object {
        private val NAME = "RNPushNotifications"
    }
}
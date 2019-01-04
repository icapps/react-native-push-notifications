package com.icapps.rnpushnotifications

import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.icapps.rnpushnotifications.persitance.SharedPrefs

/**
 * @author Koen Van Looveren
 */
class RNPushNotificationsModule internal constructor(private val reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    private val sharedPrefs = SharedPrefs(reactContext)

    @ReactMethod
    fun getFirebaseToken(promise: Promise) {
        promise.resolve(sharedPrefs.getFirebaseToken())
    }

    override fun getName(): String {
        return NAME
    }

    companion object {
        private val NAME = "RNPushNotifications"
    }
}
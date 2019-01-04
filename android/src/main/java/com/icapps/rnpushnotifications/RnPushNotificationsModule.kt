package com.icapps.rnpushnotifications

import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.icapps.rnpushnotifications.persitance.SharedPrefs

/**
 * @author Koen Van Looveren
 */
class RnPushNotificationsModule(reactContext: ReactApplicationContext) :
    ReactContextBaseJavaModule(reactContext) {

    private val sharedPrefs = SharedPrefs(reactContext)

    @ReactMethod
    private fun getFirebaseToken(promise: Promise) {
        promise.resolve(sharedPrefs.getFirebaseToken())
    }

    override fun getName(): String {
        return NAME
    }

    companion object {
        private const val NAME = "RnPushNotificationsModule"
    }
}
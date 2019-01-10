package com.icapps.rnpushnotifications.bridge.js

import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.WritableMap
import com.facebook.react.modules.core.DeviceEventManagerModule
import com.icapps.rnpushnotifications.logger.Logger
import org.json.JSONObject

/**
 * @author Koen Van Looveren
 */
class RNJsBridge(private val reactContext: ReactApplicationContext) {

    companion object {
        private const val TAG = "RNJsBridge"
        private const val DATA_KEY = "data"

        // notifyJsNewToken
        private const val NEW_TOKEN_ARG_TOKEN = "token"
        private const val NEW_TOKEN_EVENT = "newToken"

        // notifyJsNewNotification
        private const val NEW_NOTIFICATION_ARG_BACKGROUND = "background"
        private const val NEW_NOTIFICATION_ARG_ID = "notificationId"
        private const val NEW_NOTIFICATION_EVENT = "newNotification"
    }

    internal fun notifyJsNewToken(token: String) {
        val jsonObject = JSONObject()
        jsonObject.put(NEW_TOKEN_ARG_TOKEN, token)
        val json = jsonObject.toString()
        val params = Arguments.createMap()
        params.putString(DATA_KEY, json)
        sendEvent(NEW_TOKEN_EVENT, params)
    }

    internal fun notifyJsNewNotification(notificationJson: JSONObject, notificationId: Int?) {
        val json = notificationJson.toString()
        val params = Arguments.createMap()
        params.putString(DATA_KEY, json)
        if (notificationId != null)
            params.putInt(NEW_NOTIFICATION_ARG_ID, notificationId)
        params.putBoolean(NEW_NOTIFICATION_ARG_BACKGROUND, reactContext.hasActiveCatalystInstance())
        sendEvent(NEW_NOTIFICATION_EVENT, params)
    }

    private fun sendEvent(eventName: String, params: WritableMap) {
        if (reactContext.hasActiveCatalystInstance()) {
            reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter::class.java)
                    .emit(eventName, params)
        } else {
            Logger.d(TAG, "Could not deliver event. No CatalystInstance active")
        }
    }
}

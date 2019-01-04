package com.icapps.rnpushnotifications

import android.view.View
import com.facebook.react.ReactPackage
import com.facebook.react.bridge.JavaScriptModule
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ReactShadowNode
import com.facebook.react.uimanager.ViewManager
import java.util.*

/**
 * @author Koen Van Looveren
 */
class RnPushNotificationsPackage : ReactPackage {

    override fun createJSModules(): List<Class<out JavaScriptModule>> {
        return Collections.emptyList()
    }

    override fun createNativeModules(reactContext: ReactApplicationContext?): List<NativeModule> {
        if (reactContext == null) return Collections.emptyList()

        val list = mutableListOf<NativeModule>()
        list.add(RnPushNotificationsModule(reactContext))
        return list
    }

    override fun createViewManagers(reactContext: ReactApplicationContext?): List<ViewManager<View, ReactShadowNode>> {
        return Collections.emptyList()
    }
}
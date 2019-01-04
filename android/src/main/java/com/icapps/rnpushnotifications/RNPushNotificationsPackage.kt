package com.icapps.rnpushnotifications

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.JavaScriptModule
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager

import java.util.ArrayList
import java.util.Collections

/**
 * @author Koen Van Looveren
 */
class RNPushNotificationsPackage : ReactPackage {
    override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
        val list = ArrayList<NativeModule>()
        list.add(RNPushNotificationsModule(reactContext))
        return list
    }

    override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
        return Collections.emptyList()
    }

    override fun createJSModules(): List<Class<out JavaScriptModule>> {
        return Collections.emptyList()
    }
}
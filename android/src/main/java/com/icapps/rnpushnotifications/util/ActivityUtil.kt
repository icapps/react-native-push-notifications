package com.icapps.rnpushnotifications.util

import android.content.Context

/**
 * @author Koen Van Looveren
 */
object ActivityUtil {

    fun getMainActivityClass(context: Context): Class<*>? {
        val launchIntent = context.packageManager.getLaunchIntentForPackage(context.packageName)
        val className = launchIntent?.component?.className ?: return null
        return try {
            return Class.forName(className)
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
            null
        }
    }
}
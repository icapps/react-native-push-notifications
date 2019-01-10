package com.icapps.rnpushnotifications.logger

import android.util.Log
import com.icapps.rnpushnotifications.BuildConfig

/**
 * @author Koen Van Looveren
 */
object Logger {
    fun d(tag: String, content: String) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, content)
        }
    }

    fun e(tag: String, content: String) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, content)
        }
    }
}
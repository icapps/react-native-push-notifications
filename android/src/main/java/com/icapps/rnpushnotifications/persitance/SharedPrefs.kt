package com.icapps.rnpushnotifications.persitance

import android.content.Context
import android.content.SharedPreferences

/**
 * @author Koen Van Looveren
 */
class SharedPrefs(private val context: Context) {


    fun getFirebaseToken(): String? {
        return getSharedPrefs().getString(KEY_FIREBASE_TOKEN, null)
    }

    fun saveFirebaseToken(token: String?) {
        val editor = getEditor()
        if (token == null) {
            editor.remove(KEY_FIREBASE_TOKEN)
                    .apply()
            return
        }
        editor.putString(KEY_FIREBASE_TOKEN, token)
                .apply()
    }

    private fun getSharedPrefs(): SharedPreferences {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
    }

    private fun getEditor(): SharedPreferences.Editor {
        return getSharedPrefs().edit()
    }

    companion object {
        private val NAME = "firebase_shared_prefs"

        private val KEY_FIREBASE_TOKEN = "firebase_token"
    }

}
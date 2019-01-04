package com.icapps.rnpushnotifications.service

import com.google.firebase.messaging.FirebaseMessagingService
import com.icapps.rnpushnotifications.persitance.SharedPrefs

/**
 * @author Koen Van Looveren
 */
class FCMService : FirebaseMessagingService() {

    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        SharedPrefs(applicationContext).saveFirebaseToken(token)
    }
}
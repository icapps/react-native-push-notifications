package com.icapps.rnpushnotifications.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.support.v4.content.ContextCompat
import com.icapps.rnpushnotifications.model.Notification
import java.util.*

/**
 * @author Koen Van Looveren
 */
object NotificationUtil {

    fun createNotification(context: Context, background: Boolean, notification: Notification): Int? {
        val launcherClass = ActivityUtil.getMainActivityClass(context) ?: return null
        val openIntent = Intent(context, launcherClass)
        val manager = notificationManager(context)

        val notificationId = Random().nextInt()
        val contentIntent = PendingIntent.getActivity(context, notificationId, openIntent, PendingIntent.FLAG_ONE_SHOT)
        val builder = NotificationCompat.Builder(context, notification.channelId)
                .setAutoCancel(notification.autoCancel)
                .setDefaults(android.app.Notification.DEFAULT_ALL)
                .setColor(ContextCompat.getColor(context, notification.color))
                .setContentTitle(notification.title)
                .setContentText(notification.content)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentIntent(contentIntent)
                .setPriority(notification.priority)
                .setVisibility(notification.visibility)
        if (notification.smallIcon != null)
            builder.setSmallIcon(notification.smallIcon)
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                    notification.channelId,
                    notification.channelName,
                    notification.channelImporance)
            notificationChannel.enableLights(notification.channelEnableLights)
            notificationChannel.lightColor = ContextCompat.getColor(context, notification.channelColor)
            notificationChannel.enableVibration(notification.channelVibrate)
            builder.setChannelId(notification.channelId)

            manager.createNotificationChannel(notificationChannel)
        }
        manager.notify(notificationId, builder.build())
        return notificationId
    }

    fun cancelNotification(context: Context, notificationId: Int) {
        notificationManager(context).cancel(notificationId)
    }

    fun cancelAllNotifications(context: Context) {
        notificationManager(context).cancelAll()
    }

    private fun notificationManager(context: Context): NotificationManager {
        return context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }
}
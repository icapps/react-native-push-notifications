package com.icapps.rnpushnotifications.model

import android.app.NotificationManager
import android.support.annotation.ColorRes
import android.support.v4.app.NotificationCompat
import com.icapps.rnpushnotifications.R

/**
 * @author Koen Van Looveren
 */
class Notification private constructor(val title: String,
                                       val content: String,
                                       val priority: Int,
                                       val visibility: Int,
                                       val bigContent: String,
                                       val smallIcon: Int?,
                                       @ColorRes
                                       val color: Int,
                                       val autoCancel: Boolean,
                                       val channelId: String,
                                       val channelName: String,
                                       val channelImporance: Int,
                                       val channelVibrate: Boolean,
                                       val channelEnableLights: Boolean,
                                       @ColorRes
                                       val channelColor: Int) {


    class Builder(val title: String, val content: String) {
        private var bigContent: String = content
        private var priority: Int = NotificationCompat.PRIORITY_HIGH
        private var visibility: Int = NotificationCompat.VISIBILITY_PRIVATE
        private var smallIcon: Int? = null
        @ColorRes
        private var color: Int = R.color.default_notification_color
        private var autoCancel: Boolean = true
        private var channelId: String = "general-push-notification-channel"
        private var channelName: String = "General"
        private var channelImporance: Int = NotificationManager.IMPORTANCE_HIGH
        private var channelVibrate: Boolean = true
        private var channelEnableLights: Boolean = true
        @ColorRes
        private var channelColor: Int = R.color.default_notification_color

        fun setBigText(bigContent: String): Builder {
            this.bigContent = bigContent
            return this
        }

        fun setPriority(priority: Int): Builder {
            this.priority = priority
            return this
        }

        fun setVisibility(visibility: Int): Builder {
            this.visibility = visibility
            return this
        }

        fun setSmallIcon(smallIcon: Int): Builder {
            this.smallIcon = smallIcon
            return this
        }

        fun setColor(@ColorRes color: Int): Builder {
            this.color = color
            return this
        }

        fun setAutoCancel(autoCancel: Boolean): Builder {
            this.autoCancel = autoCancel
            return this
        }


        fun setChannelId(channelId: String): Builder {
            this.channelId = channelId
            return this
        }

        fun setChannelName(channelName: String): Builder {
            this.channelName = channelName
            return this
        }

        fun setChannelImporance(channelImporance: Int): Builder {
            this.channelImporance = channelImporance
            return this
        }

        fun setChannelVibrate(channelVibrate: Boolean): Builder {
            this.channelVibrate = channelVibrate
            return this
        }

        fun setChannelEnableLights(channelEnableLights: Boolean): Builder {
            this.channelEnableLights = channelEnableLights
            return this
        }

        fun setChannelColor(@ColorRes channelColor: Int): Builder {
            this.channelColor = channelColor
            return this
        }

        fun build(): Notification {
            return Notification(title,
                    content,
                    priority,
                    visibility,
                    bigContent,
                    smallIcon,
                    color,
                    autoCancel,
                    channelId,
                    channelName,
                    channelImporance,
                    channelVibrate,
                    channelEnableLights,
                    channelColor)
        }
    }
}
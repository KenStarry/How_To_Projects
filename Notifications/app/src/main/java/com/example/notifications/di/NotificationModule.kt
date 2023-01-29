package com.example.notifications.di

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.*
import androidx.core.app.NotificationManagerCompat
import com.example.notifications.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {

    @Provides
    @Singleton
    fun provideNotificationBuilder(
        @ApplicationContext context: Context
    ) : NotificationCompat.Builder {

        return NotificationCompat.Builder(context, "Main Channel ID")
            .setContentTitle("Welcome") // title
            .setContentText("Kenstarry Tech.") // subtitle
            .setSmallIcon(R.drawable.baseline_circle_notifications_24)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setVisibility(VISIBILITY_PRIVATE)
            .setPublicVersion(
                NotificationCompat.Builder(context, "Main Channel ID")
                    .setContentTitle("Hidden")
                    .setContentText("Unlock to see the message.")
                    .build()
            )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Provides
    @Singleton
    fun provideNotificationManager(
        @ApplicationContext context: Context
    ) : NotificationManagerCompat {

        val notificationManager = NotificationManagerCompat.from(context)
        val channel = NotificationChannel(
            "Main Channel ID",
            "Main Channel",
            NotificationManager.IMPORTANCE_DEFAULT
        )

        notificationManager.createNotificationChannel(channel)
        return notificationManager
    }
}




















/**
 * Copyright (c) 2012 AppLovin.
 * 
 * $(license_text)
 */
package com.applovin.sdkdemo;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.applovin.notifications.AppLovinBarNotificationFactory;
import com.applovin.notifications.AppLovinNotificationMessage;

/**
 * This factory is used to create custom bar notifications. This is part of an example {@link CustomBarNotificationActivity}.
 *
 * @author Basil Shikin
 * @since 1.1
 */
public class CustomBarNotificationFactory
    implements AppLovinBarNotificationFactory
{
    /**
     * This method is invoked when a new notification of type 'bar' has been recieved
     * and needs to be displayed. The method is invoked on a background (non-UI) thread.
     *  
     * @param notificationMessage Notification text that has been recieved. Guaranteed not to be null.
     * 
     * @return A notification that has to be displayed. 
     */
    @Override
    public Notification createNotification(AppLovinNotificationMessage message, Context context)
    {
        int appIconId = context.getApplicationInfo().icon;
        
        //
        // Use a layout from custom_bar_notification.xml to display the notification. This
        // layout looks like this:
        //
        //     +-----------------+
        //     |+-----+          |
        //     || PIC | TITLE    |
        //     ||     | SUBTITLE |
        //     |+-----+          |
        //     +-----------------+        
        //
        RemoteViews contentView = new RemoteViews( context.getPackageName(), R.layout.custom_bar_notification);
        
        //
        // message.getMessage() returns a message that was created from a template
        // defined in the UI.
        //
        contentView.setTextViewText(R.id.notification_title, message.getMessage() );
        contentView.setTextViewText(R.id.notification_subtitle, "This is a custom layout");

        //
        // message.hasPictures() and message.getPicture(0) are used to retireve any
        // pictures attached to the message. Usually these would be a contact pictures.
        // 
        if ( !message.hasPictures() ) 
        {
            contentView.setImageViewBitmap( R.id.notification_picture, message.getPicture(0) );
        }
        else
        {
            // If message does not reference any pictures, use default app picture.
            contentView.setImageViewResource( R.id.notification_picture, appIconId);
        }
        
        // You can use any intent to be broadcasted when a notification is clicked. Below is
        // an example of launch app intent
        final Intent launchAppIntent = context.getPackageManager().getLaunchIntentForPackage( context.getPackageName() );
        launchAppIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
        
        // Create custom notification: it will have custom view, intent and title.
        Notification customNotification = new Notification(appIconId, "Custom Title", System.currentTimeMillis());
        customNotification.flags = Notification.FLAG_AUTO_CANCEL;
        customNotification.contentView = contentView;
        customNotification.contentIntent = PendingIntent.getActivity( context, 0, launchAppIntent, 0);
        customNotification.defaults |= Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS;
        
        return customNotification;
    }
}

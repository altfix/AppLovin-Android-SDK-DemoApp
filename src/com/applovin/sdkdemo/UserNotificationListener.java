/**
 * Copyright (c) 2012 AppLovin.
 * 
 * $(license_text)
 */
package com.applovin.sdkdemo;

import android.util.Log;

import com.applovin.notifications.AppLovinNotificationMessage;
import com.applovin.sdk.AppLovinNotificationListener;
import com.applovin.sdk.AppLovinNotificationService;

/**
 * This class is a listener for custom push notifications. It is added to the {@link AppLovinNotificationService}. 
 * <p>
 * Please see {@link UserNotificationActivity} for the rest of the example.
 * 
 *
 * @author Basil Shikin
 * @since 1.1
 */
public class UserNotificationListener
    implements AppLovinNotificationListener
{

    /**
     * This method would be invoked when a notification is recieved
     * 
     * @param message Recieved message. Guaranteed not to be null.
     */
    public void notificationRecieved(AppLovinNotificationMessage message)
    {
        //
        // Handle push message here. Use 'message.getOriginalMessage()' to
        // retrieve message that was originally sent. Use 'message.getMessage()'
        // to retrieve a message that was resolved from a message template.
        // 
        Log.i("CustomNotificationListener", "Got a push message: " + message.getOriginalMessage() );
    }

}

/**
 * Copyright (c) 2012 AppLovin.
 * 
 * $(license_text)
 */
package com.applovin.sdkdemo;

import android.app.Activity;
import android.os.Bundle;

import com.applovin.sdk.AppLovinNotificationService;
import com.applovin.sdk.AppLovinSdk;

/**
 * This activity demonstrates how to use user notifications messages. 
 *
 * @author Basil Shikin
 * @since 1.1
 */
public class UserNotificationActivity
        extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        AppLovinSdk sdk = AppLovinSdk.getInstance(this);
        AppLovinNotificationService notificationService = sdk.getNotificationService();

        // Add a listener that will be notified of all user push messages
        notificationService.addNotificationListener(new UserNotificationListener() );
    }
}

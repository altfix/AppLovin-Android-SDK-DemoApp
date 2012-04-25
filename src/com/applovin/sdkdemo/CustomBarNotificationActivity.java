/**
 * Copyright (c) 2012 AppLovin.
 * 
 * $(license_text)
 */
package com.applovin.sdkdemo;

import android.app.Activity;
import android.os.Bundle;

import com.applovin.sdk.AppLovinSdk;


/**
 * This activity demonstrates how to use custom bar notifications. 
 *
 * @author Basil Shikin
 * @since 1.1
 */
public class CustomBarNotificationActivity
    extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //
        // Provide CustomBarNotificationFactory, it will be used to create notification messages.
        // CustomBarNotificationFactory will be called every time a BAR notification is recieved.
        // 
        final AppLovinSdk sdk = AppLovinSdk.getInstance(this);
        sdk.getNotificationService().setBarNotificationFactory( CustomBarNotificationFactory.class );
    }
}

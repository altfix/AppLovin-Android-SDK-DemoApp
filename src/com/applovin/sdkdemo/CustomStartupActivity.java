/**
 * Copyright (c) 2012 AppLovin.
 * 
 * $(license_text)
 */
package com.applovin.sdkdemo;

import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinSdk;

import android.app.Activity;
import android.os.Bundle;

/**
 * This activity demonstrates how to programmatically prompt user to opt into social ads
 * program.
 *
 * @author Basil Shikin
 * @version 1.0
 */
public class CustomStartupActivity
    extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Get an instance of an SDK
        final AppLovinSdk sdk = AppLovinSdk.getInstance( this );

        // Prompt social ads optin confirmation
        final AppLovinAdService adService = sdk.getAdService();
        adService.promptSocialAdsOptin( this );
    }
    
}

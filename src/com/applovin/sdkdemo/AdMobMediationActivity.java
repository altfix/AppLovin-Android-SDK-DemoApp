/**
 * Copyright (c) 2012 AppLovin.
 * 
 * $(license_text)
 */
package com.applovin.sdkdemo;

import com.applovin.sdk.AppLovinSdk;

import android.app.Activity;
import android.os.Bundle;

/**
 * This is the most basic example of how to add an ad.
 * 
 * @author Basil Shikin
 * @since 1.1
 */
public class AdMobMediationActivity
        extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        AppLovinSdk.initializeSdk(this);

        //
        // This loads an AdMob AdView from the admob_mediation_demo layout
        //
        // The AppLovin integration logic can be found in the AdMobMediationListener class
        //
        setContentView(R.layout.admob_mediation_demo);
    }
}

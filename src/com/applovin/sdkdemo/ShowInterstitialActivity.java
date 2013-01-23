/**
 * Copyright (c) 2012 AppLovin.
 * 
 * $(license_text)
 */
package com.applovin.sdkdemo;

import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.sdk.AppLovinSdk;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * This activity demonstrates how to trigger a display of an interstitial ad. Please see
 * <code>interstitial_demo.xml</code> for corresponding view.
 *
 * @author Basil Shikin
 * @version 1.0
 */
public class ShowInterstitialActivity
    extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        AppLovinSdk.initializeSdk(this);

        setContentView( R.layout.interstitial_demo );
        
        // Show an interstitial when a button is clicked
        final Button showInterstitial = (Button)findViewById( R.id.button_show_interstitial );
        showInterstitial.setOnClickListener( new OnClickListener() {
            public void onClick(View view)
            {
                AppLovinInterstitialAd.show( ShowInterstitialActivity.this );
            }
        } );
    }

}

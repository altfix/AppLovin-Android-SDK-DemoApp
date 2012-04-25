/**
 * Copyright (c) 2012 AppLovin.
 * 
 * $(license_text)
 */
package com.applovin.sdkdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.applovin.adview.AppLovinAdView;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;

/**
 * This activity demonstrates how to programmatically add a view into the layout.
 *
 * @author Basil Shikin
 * @version 1.0
 */
public class CustomBannerActivity
    extends Activity
{
    private AppLovinAdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.custom_banner );
        
        // Get an instance of AppLovin SDK
        final AppLovinSdk sdk = AppLovinSdk.getInstance( this );
        
        // Create new ad view
        adView = new AppLovinAdView( sdk, AppLovinAdSize.BANNER, this );
        
        // NOTE: Another way to get hold of AppLovinAdView is to add it to the
        // XML layout and use findViewById() to retrieve it.
        
        //
        // OPTINAL: Add a listener to load next ad
        //
        adView.setAdLoadListener( new AppLovinAdLoadListener() 
        {
            public void failedToReceiveAd(int errorCode)
            {
                // When ad fails to load AppLovinAdView will be automatically
                // hidden.
                //
                // Any additional logic could be placed here. Common error codes
                // are:
                //       202 -- no ad is available
                //       5xx -- server errors
                //  negative -- internal errors
            }
            
            public void adReceived(AppLovinAd newAd)
            {
                // Newly loaded ad is automatically dispalyed.
                //
                // Any additional logic could be placed here.
            }
        } );

        
        //
        // MANDATORY: Trigger loading of the next ad
        //
        adView.loadNextAd();
        
        // Add the view into the layout
        final ViewGroup adHome = (ViewGroup) findViewById( R.id.ad_home );
        adHome.addView( adView );
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        // Render next ad
        adView.loadNextAd();
    }
}

/**
 * Copyright (c) 2012 AppLovin.
 * 
 * $(license_text)
 */
package com.applovin.sdkdemo;

import android.app.Activity;
import android.os.Bundle;

import com.adwhirl.AdWhirlLayout;
import com.adwhirl.AdWhirlLayout.AdWhirlInterface;
import com.applovin.adview.AppLovinAdView;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;

/**
 * This activity demonstrates how to integrate AppLovin SDK with AdWhil.
 * <p>
 * AppLovin integration uses AdWhirl Custom Events mechanism.
 * 
 *
 * @author Basil Shikin
 */
public class AdWhirlIntegrationDemo
    extends Activity
    implements AdWhirlInterface  
{
    private AdWhirlLayout adWhirlLayout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        AppLovinSdk.initializeSdk(this);

        setContentView( R.layout.adwhirl_integration_demo );
        
        adWhirlLayout = (AdWhirlLayout)findViewById( R.id.adwhirl );
        adWhirlLayout.setAdWhirlInterface( this ); // This is needed to recieve AdWhirl events
    }
    
    /**
     * This method will be called by AdWhirl through Custom Event mechanism.
     * <p>
     * Name of this method MUST be the same as one added in AdWhirl web interface.
     */
    public void appLovinAdRequest()
    {
        // Create new and add AppLovin Ad View
        final AppLovinAdView appLovinAdView = new AppLovinAdView(AppLovinAdSize.BANNER, this );
        appLovinAdView.setAdLoadListener( new AppLovinAdLoadListener() 
        {
            public void adReceived(AppLovinAd newAd)
            {
                adWhirlLayout.adWhirlManager.resetRollover();
                adWhirlLayout.rotateThreadedDelayed();
            }
            
            public void failedToReceiveAd(int errorCode)
            {
                adWhirlLayout.rollover();
            }
        } );
        appLovinAdView.loadNextAd();
        
        adWhirlLayout.addView( appLovinAdView );
    }

    /**
     * This is a generic notification method, it is not needed
     * for AppLovin Integration
     */
    public void adWhirlGeneric()
    {
    }

}

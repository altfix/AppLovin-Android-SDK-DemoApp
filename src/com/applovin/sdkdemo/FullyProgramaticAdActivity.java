/**
 * Copyright (c) 2012 AppLovin.
 * 
 * $(license_text)
 */
package com.applovin.sdkdemo;

import android.app.Activity;
import android.os.Bundle;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;

/**
 * This is a demonstration of how to load ads withough using AppLovin Ad view.
 * 
 * <p>
 *    <b>Please note:</b> This is a very advanced usage of the SDK. It is not recommended
 *                        for majority of use cases.
 * </p> 
 *
 * @author Basil Shikin
 * @since 1.0
 */
public class FullyProgramaticAdActivity
    extends Activity
    implements AppLovinAdLoadListener
{
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        AppLovinSdk sdk = AppLovinSdk.getInstance( this );
        AppLovinAdService adService = sdk.getAdService();
        adService.loadNextAd( AppLovinAdSize.BANNER, this ); // This activity implements AppLovinAdLoadListener
    }

    /**
     * This method is called when a new ad has been received. This method is invoked
     * on a background thread.
     *   
     * @param ad Newly received ad. Guaranteed not to be null.
     */
    public void adReceived(AppLovinAd ad)
    {
        // This HTML could be used to render an ad in any custom 
        // web view
//        String adHTML = ad.getHtml();
        
        // When the ad is clicked one should invoke this code to track
        // the click:
        
//        AppLovinSdk sdk = AppLovinSdk.getInstance( this );
//        AppLovinAdService adService = sdk.getAdService();
//        adService.trackAdClick( ad );
    }

    /**
     * This method is called when an ad could not be retrieved from the server.
     * This method is invoked on a background thread.
     * <p>
     * Common error codes are: </br>
     *     <code>202</code> -- no ad is available</br>
     *     <code>5xx</code> -- internal server error</br>
     *     <code>negative number</code> -- internal errors </br>
     *     
     * @param errorCode An error code recieved from the server.
     */
    public void failedToReceiveAd(int errorCode)
    {
        // Handle ad load failure here
    }
}
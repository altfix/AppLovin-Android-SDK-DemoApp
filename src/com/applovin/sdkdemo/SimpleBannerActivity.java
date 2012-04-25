/**
 * Copyright (c) 2012 AppLovin.
 * 
 * $(license_text)
 */
package com.applovin.sdkdemo;

import android.app.Activity;
import android.os.Bundle;

/**
 * This is the most basic example of how to add an ad.
 *
 * @author Basil Shikin
 * @since 1.1
 */
public class SimpleBannerActivity
    extends Activity
{
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        //
        // PLEASE NOTE:
        //
        // (1) simple_banner.xml includes following view:
        //
        //          <com.applovin.views.AppLovinAdView     
        //                                              android:layout_width="fill_parent"
        //                                              android:layout_height="wrap_content" />
        //
        // (2) AndroidManifest.xml includes following lines:
        //
        //          <uses-permission android:name="android.permission.INTERNET"/>
        //          . . .
        //          <application>
        //              . . .
        //              <meta-data android:value="YOUR_SDK_KEY_HERE" android:name="APPLOVIN_SDK_KEY" />
        //           </application>
        //
        setContentView(R.layout.simple_banner);
    }
}

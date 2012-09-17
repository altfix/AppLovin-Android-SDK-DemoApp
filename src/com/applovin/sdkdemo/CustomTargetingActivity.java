/**
 * Copyright (c) 2012 AppLovin.
 * 
 * $(license_text)
 */
package com.applovin.sdkdemo;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;

import com.applovin.adview.AppLovinAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinTargetingData;

/**
 * This is the most basic example of how to add an ad.
 * 
 * @author David Anderson
 * @since 4.0.1
 */
public class CustomTargetingActivity
        extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        AppLovinSdk sdk = AppLovinSdk.getInstance(this);
        AppLovinTargetingData targeting = sdk.getTargetingData();

        //
        // Set device current device ID. Device ID should an value returned by
        // android.telephony.TelephonyManager::getDeviceId()
        //
        // Please note: Raw value will not be transferred over the network.
        // AppLovin SDK will hash the value before using it.
        //
        targeting.setDeviceId("xxxxxxxxx");

        //
        // Set carrier current device is on.
        //
        targeting.setCarrier("tmobile");

        //
        // Set a two-character ISO 3166-1 country code of the device.
        //
        targeting.setCountry("US");

        //
        // Android ID of the device
        //
        // Please note: Raw value will not be transferred over the
        // network. AppLovin SDK will hash the value before using it.
        //
        targeting.setAndroidId("xxxxxxxxx");

        //
        // MAC address of the device's Wi-Fi module.
        //
        // Please note: Raw value will not be transfered over the
        // network. AppLovin SDK will hash the value before using it.
        //
        targeting.setMacAddress("00:00:00:00:00:00");

        //
        // Set phone number of the current user.
        //
        // Please note: Raw phone number will not be transferred over the
        // network. AppLovin SDK will hash the value before using it.
        //
        targeting.setPhoneNumber("+1-555-555-1234");

        //
        // Set an email of the current user.
        //
        // Please note: Raw value will not be transferred over the
        // network. AppLovin SDK will hash the value before using it.
        //
        targeting.setEmail("test@gmail.com");

        //
        // OR you can set multiple emails for the user
        //
        targeting.setEmails("test@gmail.com", "test@yahoo.com", "test@live.com");

        //
        // Set the first name of current user.
        //
        targeting.setFirstName("Bob");

        //
        // Set the year of birth of current user.
        //
        targeting.setBirthYear(1978);

        //
        // Set the gender of current user. Use GENDER_MALE and GENDER_FEMALE
        // constants of this class or pass 'm' or 'f' directly.
        //
        targeting.setGender(AppLovinTargetingData.GENDER_MALE);

        //
        // Set the location of current user.
        //
        Location location = new Location("user");
        targeting.setLocation(location);

        //
        // Set the language of current user. Language is expressed as
        // two-character ISO 639-1 language code.
        //
        targeting.setLanguage("RU");

        //
        // Set keywords for the application.
        //
        targeting.setKeywords("applovin", "test", "demo", "example");

        //
        // Set interests for the user.
        //
        targeting.setInterests("books", "games", "pizza");

        //
        // Put an extra targeting parameter
        //
        targeting.putExtra("some_key", "some_value");

        //
        // Clear all saved targeting data
        //

        // targeting.clearData();


        //
        // We set targeting parameters before loading the layout
        // so that they go up in the first ad request.
        //
        setContentView(R.layout.custom_targeting_demo);
    }
}

/**
 * Copyright (c) 2012 AppLovin.
 * 
 * $(license_text)
 */
package com.applovin.sdkdemo;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;

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
        // Set carrier current device is on.
        //
        targeting.setCarrier("tmobile");

        //
        // Set a two-character ISO 3166-1 country code of the device.
        //
        targeting.setCountry("US");

        //
        // Set phone number of the current user.
        //
        // Please note: Raw phone number will not be transferred over the
        // network. AppLovin SDK will hash the value before sending it.
        //
        targeting.setPhoneNumber("+1-555-555-1234");

        //
        // Set email of the current user.
        //
        // Please note: Raw value will not be transferred over the
        // network. AppLovin SDK will hash the value before sending it.
        //
        targeting.setEmail("test@gmail.com");

        //
        // OR you can set multiple emails for the user
        //
        targeting.setEmails("test@gmail.com", "test@yahoo.com", "test@live.com");

        //
        // Set the first name of the current user.
        //
        targeting.setFirstName("Bob");

        //
        // Set the year of birth of the current user.
        //
        targeting.setBirthYear(1978);

        //
        // Set the gender of the current user. Use GENDER_MALE and GENDER_FEMALE
        // constants of this class or pass 'm' or 'f' directly.
        //
        targeting.setGender(AppLovinTargetingData.GENDER_MALE);

        //
<<<<<<< HEAD
        // Set highest level of education for the current user. Supported education values are
        // defined in the following constants: EDUCATION_NONE, EDUCATION_HIGH_SCHOOL, 
        // EDUCATION_COLLEGE, EDUCATION_BACHELORS, EDUCATION_MASTERS,
        // EDUCATION_DOCTORAL and EDUCATION_OTHER
=======
        // Set highest level of education of current user. Supported education values are
        // defined in following constants: EDUCATION_NONE, EDUCATION_HIGH_SCHOOL, 
        // EDUCATION_SOME_COLLEGE, EDUCATION_IN_COLLEGE, EDUCATION_BACHELORS, 
        // EDUCATION_MASTERS, EDUCATION_DOCTORAL and EDUCATION_OTHER
>>>>>>> Fixed constant names
        //
        targeting.setEducation( AppLovinTargetingData.EDUCATION_BACHELORS );
        
        //
        // Set the marital status of the current user. Supported values are
        // defined in the following constants: MARITAL_STATUS_NONE, 
        // MARITAL_STATUS_SINGLE, MARITAL_STATUS_MARRIED, 
        // MARITAL_STATUS_DIVORCED and MARITAL_STATUS_WIDOWED
        //
        targeting.setMaritalStatus( AppLovinTargetingData.MARITAL_STATUS_SINGLE );
        
        //
        // Set ethnicity of the current user. Supported values are
        // defined in the following constants: ETHNICITY_NONE, ETHNICITY_MIXED, 
        // ETHNICITY_ASIAN, ETHNICITY_BLACK, ETHNICITY_HISPANIC, 
        // ETHNICITY_NATIVE_AMERICAN, ETHNICITY_WHITE and ETHNICITY_OTHER.
        //
        targeting.setEthnicity( AppLovinTargetingData.ETHNICITY_MIXED );
        
        //
        // Set the user's income. Income format can be as follows:
        //   - An exact number like 100000 or 100K
        //   - A range like 10K-30K
        //   - A range like <100K
        //
        targeting.setIncome("80000-120K");
        
        //
        // Set the location of the current user.
        //
        Location location = new Location("user");
        targeting.setLocation(location);

        //
        // Set the language of the current user. Language is expressed as
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
        // Put an extra targeting parameter.
        //
        targeting.putExtra("some_key", "some_value");

        //
        // Clear all saved targeting data.
        //

        // targeting.clearData();


        //
        // We set targeting parameters before loading the layout
        // so that they go up in the first ad request.
        //
        setContentView(R.layout.custom_targeting_demo);
    }
}

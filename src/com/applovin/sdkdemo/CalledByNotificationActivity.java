/**
 * Copyright (c) 2012 AppLovin.
 * 
 * $(license_text)
 */
package com.applovin.sdkdemo;

import java.io.InputStream;

import com.applovin.notifications.AppLovinBarNotificationFactory;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds;
import android.provider.ContactsContract.Contacts;
import android.util.Log;

/**
 * This activity illustrates how to extract contact information when the activity was started from a Social Push click.
 * <p>
 * In other words, this activity was started when a user recieved social push notification that contained a contact, the
 * activity can access data that was in the notification. For example, the push message was "Basil has purchased a towel!". 
 * User clicks on the message and this activity is started. The application can extract Basil's contact ID from the launch
 * intent and display relvant message in the app.
 *
 * @author Basil Shikin
 * @since 3.1
 */
public class CalledByNotificationActivity
    extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        // Get intent
        Intent launchIntent = getIntent();
        Bundle extras = launchIntent.getExtras();
        if ( extras != null )
        {
            // Get contact ID that was referenced in AppLovin Bar Notification 
            final long contactId = extras.getLong( AppLovinBarNotificationFactory.KEY_FIRST_CONTACT_ID );
            
            // If there was a contact
            if ( contactId > 0 )
            {
                String displayName = loadDisplayName( contactId );    
                String phoneNumber = loadPhoneNumber( contactId );    
                Bitmap picture     = loadPicture( contactId );
                
                // Do something with contact information
                Log.i("AppLovinDemo", "Bar Notification had contact: " + displayName + " (" + phoneNumber + "), there is " + ( picture != null ? "a picture" : "no picture" ) );
            }
        }
        
        // Proceed with onCreate
    }

    /**
     * Load contact picture for a given contact ID
     * 
     * @param contactId Android contact ID
     * 
     * @return Contact picture or null if none found
     */
    private Bitmap loadPicture(long contactId)
    {
        Uri contactUri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, contactId );
        
        InputStream photoDataStream = Contacts.openContactPhotoInputStream(getContentResolver(), contactUri); 
        return BitmapFactory.decodeStream(photoDataStream);
    }

    /**
     * Load the first phone number for a given contact ID
     * 
     * @param contactId Android contact ID
     * 
     * @return Contact phone number or null if none found
     */
    private String loadPhoneNumber(long contactId)
    {
        Cursor cursor = getContentResolver().query( CommonDataKinds.Phone.CONTENT_URI, 
                                                    new String[] { CommonDataKinds.Phone.NUMBER } , 
                                                    CommonDataKinds.Phone.CONTACT_ID +" = "+ contactId, 
                                                    null, null);
        try 
        {
            if (cursor.moveToFirst()) 
            {
                return cursor.getString( cursor.getColumnIndex( CommonDataKinds.Phone.NUMBER ) ) ;
            }
        } 
        finally 
        {
            cursor.close();
        } 
        
        return null; // If no name found return null
    }

    /**
     * Load display name for a given contact ID
     * 
     * @param contactId Android contact ID
     * 
     * @return Contact display name or null if none found
     */
    private String loadDisplayName(long contactId)
    {
        Uri contactUri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, contactId );
        
        Cursor cursor = getContentResolver().query( contactUri,
                                                    new String[]{ ContactsContract.Contacts.DISPLAY_NAME} , 
                                                    null, null, null);
        try 
        {
            if (cursor.moveToFirst()) 
            {
                return cursor.getString( cursor.getColumnIndex( ContactsContract.Contacts.DISPLAY_NAME ) ) ;
            }
        } 
        finally 
        {
            cursor.close();
        }   
        
        return null; // If no name found return null
    }
}
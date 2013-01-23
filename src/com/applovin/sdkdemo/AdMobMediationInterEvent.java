package com.applovin.sdkdemo;

import android.app.Activity;

import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdk;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.customevent.CustomEventInterstitial;
import com.google.ads.mediation.customevent.CustomEventInterstitialListener;

/**
 * This class must be defined and referenced from AdMob's website for AdMob Mediation
 * 
 * @author David Anderson
 * @since 4.2
 */
public class AdMobMediationInterEvent implements CustomEventInterstitial
{ 
    
    /**
     * This method will be called by AdMob's Mediation through Custom Event mechanism.
     */
    @Override
    public void requestInterstitialAd(final CustomEventInterstitialListener listener,
            final Activity activity,
            String label,
            String serverParameter,
            MediationAdRequest request)
    {
        AppLovinInterstitialAdDialog dialog = AppLovinInterstitialAd.create(AppLovinSdk.getInstance(activity), activity);

        dialog.setAdDisplayListener(new AppLovinAdDisplayListener() {
            @Override
            public void adHidden(AppLovinAd ad)
            {
                listener.onDismissScreen();
            }

            @Override
            public void adDisplayed(AppLovinAd ad)
            {
                listener.onPresentScreen();
            }
        });

        dialog.setAdLoadListener(new AppLovinAdLoadListener() {
            @Override
            public void failedToReceiveAd(int arg0)
            {
                listener.onFailedToReceiveAd();
            }

            @Override
            public void adReceived(AppLovinAd ad)
            {
                listener.onReceivedAd();
            }
        });

        dialog.show();
    }

    @Override
    public void showInterstitial()
    {        
    }
}
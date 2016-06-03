package com.beardstyles.battydevs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class SingleViewActivity extends Activity {
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.single_view);

      MobileAds.initialize(getApplicationContext(), "ca-app-pub-4876187285163663/7119323236");
      AdView mAdView = (AdView) findViewById(R.id.adView);
      AdRequest adRequest = new AdRequest.Builder().build();
      mAdView.loadAd(adRequest);

      // Get intent data
      Intent i = getIntent();

      // Selected image id
      int position = i.getExtras().getInt("id");
      ImageAdapter imageAdapter = new ImageAdapter(this);


      ImageView imageView = (ImageView) findViewById(R.id.SingleView);
      imageView.setImageResource(imageAdapter.mThumbIds[position]);
   }
}
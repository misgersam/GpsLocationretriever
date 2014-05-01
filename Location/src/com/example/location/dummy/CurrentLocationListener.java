package com.example.location.dummy;
/**
 * @author smisger
 * Date: 28 Apr 2014
 * Prospecta Software Pty. Ltd
 * This class will be used to fetch current location latitude and longitude, permissions should be given to use network and location in android manifest.xml
 */
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class CurrentLocationListener implements LocationListener {

	public String latitude;
	public String longitude;
	private TextView mTextView;
	private Context ctx;
	public CurrentLocationListener(String latitude, String longitude, TextView tv, Context ctx) {
	    this.latitude=latitude;
	    this.longitude=longitude;
	    this.mTextView = tv;
	    this.ctx=ctx;
	    Toast.makeText(ctx, "constructor", 4000).show();
	}

	@Override
	public void onLocationChanged(Location location) {
		Toast.makeText(ctx, "location cahnged called", 4000).show();
		System.out.println("location changed called");
		if(location != null){
			System.out.println("location not null");
			latitude = String.valueOf(location.getLatitude());
			longitude = String.valueOf(location.getLongitude());
			mTextView.setText("Latitude = " + location.getLatitude() + " Longitude = " + location.getLongitude());
		}
	}

	@Override
	public void onStatusChanged(String s, int i, Bundle bundle) {

	}

	@Override
	public void onProviderEnabled(String s) {

	}

	@Override
	public void onProviderDisabled(String s) {

	}
}
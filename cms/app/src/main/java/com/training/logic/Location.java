package com.training.logic;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.training.cms.MainActivity;

public class Location {

    //Defining needed attributes and variables
    private Context context;
    private MainActivity mainActivity;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private double lon, lat;
    public static final int PERMISSIONS_FINE_LOCATION = 99;
    private final long UPDATE_INTERVAL_IN_MILLISECONDS = 500;
    private final long UPDATE_FASTEST_INTERVAL_IN_MILLISECONDS = UPDATE_INTERVAL_IN_MILLISECONDS / 2;
    private LocationRequest locationRequest;
    private LocationCallback locationCallBack;

    //Constructor
    public Location(Context context,MainActivity mainActivity) {
        this.context = context;
        this.mainActivity = mainActivity;
        //Setting up locationRequest properties
        this.locationRequest = new LocationRequest();
        locationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
        locationRequest.setFastestInterval(UPDATE_FASTEST_INTERVAL_IN_MILLISECONDS);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        //Callback function to be called when a new location is captured
        this.locationCallBack = new LocationCallback() {
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                //save and update location
                android.location.Location location = locationResult.getLastLocation();
                updateCoordinates(location);
            }
        };
    }

    //Start capturing location of th user
    public void startLocationUpdates()
    {
        boolean granted = ActivityCompat.checkSelfPermission(this.context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        if(granted)
            fusedLocationProviderClient.requestLocationUpdates(locationRequest,locationCallBack,null); //Requesting location updates, and when an update is received call the callback function
    }

    //Stop capturing location of th user
    public void stopLocationUpdates()
    {
        fusedLocationProviderClient.removeLocationUpdates(locationCallBack);
    }

    //Starting point
    public void updateGPS()
    {
        //Setting up the fusedLocationProviderClient
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.mainActivity);


        //Checking for GPS permission to see if it's granted or not
        if(ActivityCompat.checkSelfPermission(this.context,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            //User granted permission, gets the last captured location
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<android.location.Location>() {
                @Override
                public void onSuccess(android.location.Location location) {
                    //Start capturing location
                    startLocationUpdates();
                }
            });
        }
        else //Permission not granted
        {
            //Ask for permissions
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                this.mainActivity.requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_FINE_LOCATION);
        }
    }

    //This function is called every time a new location is captured
    public void updateCoordinates(android.location.Location location)
    {
        double[] coordinates = new double[2];
        coordinates[0] = lon = location.getLongitude();
        coordinates[1] = lat = location.getLatitude();
        //Send data to the MainView to update the view and send them to the web server
        mainActivity.receiveLocation(coordinates);
    }

}







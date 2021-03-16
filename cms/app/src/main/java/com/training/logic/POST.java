package com.training.logic;

import android.content.Context;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class POST {
    //Defining needed objects and variables
    private Context context;

    //Constructor
    public POST(Context context) {
        this.context = context;
    }

    //Sending a POST request to the user data url
    public void sendUserRequest(String[] userInformation) {
        //If the python script isn't started, start it
        if (!Python.isStarted())
            Python.start(new AndroidPlatform(this.context));
        //Setting up connection with the python script
        Python python = Python.getInstance();
        PyObject pythonFile = python.getModule("SendRequest"); //py file name
        PyObject pythonMethod = pythonFile.callAttr("sendUserRequest", userInformation[0],
                userInformation[1], userInformation[2], userInformation[3], userInformation[4],
                userInformation[5], userInformation[6], userInformation[7]
        ); //name of the method and its parameters
    }

    //Sending a POST request to the location data url
    public void sendLocationRequest(String userId, double[] coordinates) {
        //If the python script isn't started, start it
        if (!Python.isStarted())
            Python.start(new AndroidPlatform(this.context));
        //Setting up connection with the python script
        Python python = Python.getInstance();
        PyObject pythonFile = python.getModule("SendRequest");
        PyObject pythonMethod = pythonFile.callAttr("sendLocationRequest", userId, coordinates[0], coordinates[1]);
    }

    //Sending a POST request to the car stats url
    public void sendCarStatsRequest(String userId, String[] carStats) {
        //If the python script isn't started, start it
        if (!Python.isStarted())
            Python.start(new AndroidPlatform(this.context));
        //Setting up connection with the python script
        Python python = Python.getInstance();
        PyObject pythonFile = python.getModule("SendRequest");
        PyObject pythonMethod = pythonFile.callAttr("sendCarStatsRequest", userId,
                carStats[0], carStats[1], carStats[2], carStats[4], carStats[3]
        );
    }

}

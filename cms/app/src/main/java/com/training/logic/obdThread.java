package com.training.logic;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.util.Log;

import com.github.pires.obd.commands.SpeedCommand;
import com.github.pires.obd.commands.engine.OilTempCommand;
import com.github.pires.obd.commands.engine.RPMCommand;
import com.github.pires.obd.commands.fuel.FuelLevelCommand;
import com.github.pires.obd.commands.protocol.EchoOffCommand;
import com.github.pires.obd.commands.protocol.LineFeedOffCommand;
import com.github.pires.obd.commands.protocol.SelectProtocolCommand;
import com.github.pires.obd.commands.protocol.TimeoutCommand;
import com.github.pires.obd.commands.temperature.AmbientAirTemperatureCommand;
import com.github.pires.obd.commands.temperature.EngineCoolantTemperatureCommand;
import com.github.pires.obd.commands.temperature.TemperatureCommand;
import com.github.pires.obd.enums.ObdProtocols;
import com.training.cms.MainActivity;

import java.io.IOException;
import java.util.UUID;

public class obdThread implements Runnable{

    //Defining needed attributes and variables
    private MainActivity mainActivity;
    private String[] carStats;
    private BluetoothAdapter btAdapter;
    private BluetoothDevice device;
    private BluetoothSocket socket;
    private UUID uuid;

    //Constructor
    public obdThread(MainActivity mainActivity)
    {
        this.mainActivity = mainActivity;
        //Connecting to the device's bluetooth
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        device = btAdapter.getRemoteDevice(MainActivity.deviceAddress);
        //uuid for serial port communication
        uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

        try {
            //Creating communication socket
            socket = device.createInsecureRfcommSocketToServiceRecord(uuid);
        }catch (IOException e) {
            System.out.println("IOException in socket connector: " + e);
        }
    }

    //Close the communication socket
    public void closeConnection()
    {
        try {
            this.socket.close();
        } catch (IOException e) {
            System.out.println("Error with closing the connection");
        }
    }

    //Starting point
    @Override
    public void run() {
        try {
            //Open the socket for the communication
            this.socket.connect();
            //Initializing the OBD
            new EchoOffCommand().run(socket.getInputStream(), socket.getOutputStream());
            new LineFeedOffCommand().run(socket.getInputStream(), socket.getOutputStream());
            new TimeoutCommand(125).run(socket.getInputStream(), socket.getOutputStream());
            new SelectProtocolCommand(ObdProtocols.AUTO).run(socket.getInputStream(), socket.getOutputStream());
            new AmbientAirTemperatureCommand().run(socket.getInputStream(), socket.getOutputStream());

            while (!Thread.currentThread().isInterrupted() && socket.isConnected()) {
                //Defining OBD commands
                RPMCommand engineRpmCommand = new RPMCommand();
                SpeedCommand speedCommand = new SpeedCommand();
                EngineCoolantTemperatureCommand coolantTemperatureCommand = new EngineCoolantTemperatureCommand();
                FuelLevelCommand fuelLevelCommand = new FuelLevelCommand();
                OilTempCommand oilTempCommand = new OilTempCommand();

                //Running the OBD commands
                engineRpmCommand.run(socket.getInputStream(), socket.getOutputStream());
                speedCommand.run(socket.getInputStream(), socket.getOutputStream());
                coolantTemperatureCommand.run(socket.getInputStream(), socket.getOutputStream());
                fuelLevelCommand.run(socket.getInputStream(), socket.getOutputStream());
                //oilTempCommand.run(socket.getInputStream(), socket.getOutputStream());

                //Storing the results of running those commands
                String rpm =  engineRpmCommand.getFormattedResult();
                String speed = speedCommand.getFormattedResult();
                String fuelLevel =fuelLevelCommand.getFormattedResult();
                String coolantTemp = coolantTemperatureCommand.getFormattedResult();
                //String oilTemp = oilTempCommand.getFormattedResult();
                String oilTemp = "No data";

                //Send the result to the MainView to update the iew and send the data to the web server
                carStats = new String[] {speed,rpm,coolantTemp,oilTemp,fuelLevel};
                mainActivity.receiveCarStats(carStats);
            }
            //When the tread is interrupted, close the socket
            closeConnection();
        }
        //If any exception rises, close the socket
        catch (IOException e) {
            System.out.println("IOException in socket connector: " + e);
            closeConnection();
        }catch (InterruptedException e){
            System.out.println("InterruptedException in socket connector: " + e);
            closeConnection();
        }
    }
}
package com.training.cms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.training.logic.Location;
import com.training.logic.POST;
import com.training.logic.obdThread;

import java.util.ArrayList;
import java.util.Set;

import javax.annotation.Nullable;


public class MainActivity extends AppCompatActivity {
    private static final int GALLERY_INTENT_CODE = 1023 ;
    //View reference objects
    private TextView fullNameReference,emailReference,phoneReference,addressReference,carInformationReference,
            latitudeReference,longitudeReference,
            rpmReference,speedReference,engineTempReference,fuelReference,oilReference;
    private ImageView profileImage;
    private Button resendCode;
    private Button resetPassLocal,changeProfileImage;
    //Firebase objects
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseStore;
    private FirebaseUser firebaseUser;
    //User Information
    private String userId;
    //Location
    private Location location;
    //OBD
    private Thread obdThread;
    public static final String TAG = "MainActivity";
    public static String deviceAddress;
    //POST Requests
    private POST post;

    //Starting point
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //POST
        post = new POST(this);
        //Location Start
        location = new Location(this,MainActivity.this);
        location.updateGPS();
        //Referencing views
        //Texts
        fullNameReference = findViewById(R.id.profileName);
        emailReference = findViewById(R.id.profileEmail);
        phoneReference = findViewById(R.id.profilePhone);
        addressReference = findViewById(R.id.profileAddress);
        carInformationReference = findViewById(R.id.profileCarInformation);
        latitudeReference = findViewById(R.id.latitude);
        longitudeReference = findViewById(R.id.longitude);
        rpmReference = findViewById(R.id.rpm);
        speedReference = findViewById(R.id.speed);
        engineTempReference = findViewById(R.id.coolantTemp);
        fuelReference = findViewById(R.id.fuelLevel);
        oilReference = findViewById(R.id.oilTemp);
        //Buttons and images
        resetPassLocal = findViewById(R.id.resetPasswordLocal);
        profileImage = findViewById(R.id.profileImage);
        changeProfileImage = findViewById(R.id.changeProfile);
        resendCode = findViewById(R.id.resendCode);
        //Firebase
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseStore = FirebaseFirestore.getInstance();
        userId = firebaseAuth.getCurrentUser().getUid();
        firebaseUser = firebaseAuth.getCurrentUser();
        //Get logged user data to display them in the main view
        DocumentReference documentReference = firebaseStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                //If the document of that user exists, set the views' texts to that data
                if(documentSnapshot.exists()){

                    fullNameReference.setText(documentSnapshot.getString("name"));
                    emailReference.setText(documentSnapshot.getString("email"));
                    carInformationReference.setText(documentSnapshot.getString("carMake")+","
                                                    +documentSnapshot.getString("carModel")+","
                                                    +documentSnapshot.getString("carYear"));
                }else {
                    Log.d("tag", "onEvent: Document do not exists");
                }
            }
        });
        //Resetting password
        resetPassLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText resetPassword = new EditText(v.getContext());

                final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password ?");
                passwordResetDialog.setMessage("Enter New Password >= 6 Characters long.");
                passwordResetDialog.setView(resetPassword);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // extract the email and send reset link
                        String newPassword = resetPassword.getText().toString();
                        firebaseUser.updatePassword(newPassword).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(MainActivity.this, "Password Reset Successfully.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Password Reset Failed.", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // close
                    }
                });

                passwordResetDialog.create().show();

            }
        });
    }

    //Called from the location to update the view and send the data to the web server
    public void receiveLocation(double[] coordinates)
    {
        System.out.println("Main/Coordinates:\nlon:"+coordinates[0]+"   lat:"+coordinates[1]);
        //String locationResult = post.sendLocationRequest(userId,coordinates);
        post.sendLocationRequest(userId,coordinates);
        latitudeReference.setText("Latitude: "+coordinates[1]);
        longitudeReference.setText("Longitude: "+coordinates[0]);
    }

    //Called from the obdThread to update the view and send the data to the web server
    public void receiveCarStats(String[] carStats)
    {
        post.sendCarStatsRequest(userId,carStats);
        speedReference.setText("Speed: "+carStats[0]);
        rpmReference.setText("RPM: "+carStats[1]);
        engineTempReference.setText("Engine Temperature: "+carStats[2]);
        fuelReference.setText("Fuel level: "+carStats[4]);
        oilReference.setText("Oil Temperature: "+carStats[3]);
    }

    //Fires when the user selects to allow or reject GPS access
    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        switch(requestCode)
        {
            case Location.PERMISSIONS_FINE_LOCATION:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    location.updateGPS();
                }
                else
                {
                    Toast.makeText(this,"This app needs this permission to work",Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
        }
    }

    //Log-out function, fires when the user selects log-out button
    public void logout(View view) {
        location.stopLocationUpdates(); //Stop sending location updates
        obdThread.interrupt(); //Interrupts and closes the connection to the obd
        FirebaseAuth.getInstance().signOut(); //logs out the user
        startActivity(new Intent(getApplicationContext(),Login.class)); //Starts the log-in activity
        finish(); //Closes the current activity
    }

    //Connecting to the OBD
    public void connect(View view)
    {
        //Defining lists to store data in
        ArrayList deviceStrs = new ArrayList();
        final ArrayList devices = new ArrayList();
        //Connecting to the device's bluetooth to get the paired devies
        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> pairedDevices = btAdapter.getBondedDevices();
        //If paired devices were found
        if (pairedDevices.size() > 0)
        {
            //Store the paired devices and their addresses in the arraylist
            for (BluetoothDevice device : pairedDevices)
            {
                deviceStrs.add(device.getName() + "\n" + device.getAddress());
                devices.add(device.getAddress());
            }
        }
        //Constructing an alert dialog that contains the paired devices to show to the user
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_singlechoice,
                deviceStrs.toArray(new String[deviceStrs.size()]));
        //Fires when the user selects one of the paired devices
        alertDialog.setSingleChoiceItems(adapter, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                //Close the alert dialog
                dialog.dismiss();
                //Get the location of the selected device
                int position = ((AlertDialog) dialog).getListView().getCheckedItemPosition();
                //Store the mac address of the selected device to use later
                String deviceAddress = (String) devices.get(position);
                MainActivity.deviceAddress = deviceAddress;
                //Starting the OBD thread
                obdThread = new Thread(new obdThread(MainActivity.this));
                obdThread.start();
            }
        });
        //Showing the alert dialog to the user
        alertDialog.setTitle("Choose Bluetooth device");
        alertDialog.show();
    }

}
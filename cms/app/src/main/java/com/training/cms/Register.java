package com.training.cms;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.training.logic.POST;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    public static final String TAG = "TAG";
    //Defining references to the view components
    private EditText fullNameReference,emailReference,passwordReference,phoneReference,carModelReference,carMakeReference,carYearReference,addressReference;
    private Button registerButton;
    private TextView loginButton;
    private ProgressBar progressBar;
    //Defining the needed objects for the firebase operations
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseStore;
    //User info
    private String userID;
    //Defining te POST object to connect to the server
    private POST post;

    //Check if the received data is empty
    private void checkData(String data,EditText dataSource)
    {
        if (TextUtils.isEmpty(data))
        {
            dataSource.setError("Data is Required.");
            return;
        }
    }

    //Starting point
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Initializing the objects
        post = new POST(this);
        //Text references
        fullNameReference = findViewById(R.id.fullName);
        emailReference = findViewById(R.id.email);
        passwordReference = findViewById(R.id.password);
        phoneReference = findViewById(R.id.phone);
        addressReference = findViewById(R.id.address);
        carModelReference = findViewById(R.id.carModel);
        carMakeReference = findViewById(R.id.carMake);
        carYearReference = findViewById(R.id.carYear);
        //Button references
        registerButton = findViewById(R.id.registerBtn);
        loginButton = findViewById(R.id.createText);
        progressBar = findViewById(R.id.progressBar);
        //Firebase
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseStore = FirebaseFirestore.getInstance();

        //Check if the user is already logged in, redirect him to the main view
        if(firebaseAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        //The user selects register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Getting the inputted data from the text references
                final String emailData = emailReference.getText().toString().trim();
                final String passwordData = passwordReference.getText().toString().trim();
                final String fullNameData = fullNameReference.getText().toString();
                final String phoneData    = phoneReference.getText().toString();
                final String addressData = addressReference.getText().toString().trim();
                final String carModelData = carModelReference.getText().toString().trim();
                final String carMakeData = carMakeReference.getText().toString().trim();
                final String carYearData = carYearReference.getText().toString().trim();

                //Checking the validity of the data
                checkData(emailData,emailReference);
                checkData(passwordData,passwordReference);
                if(passwordData.length() < 6){
                    passwordReference.setError("Password Must be >= 6 Characters");
                    return;
                }
                checkData(fullNameData,fullNameReference);
                checkData(phoneData,phoneReference);
                checkData(carModelData,carModelReference);
                checkData(carMakeData,carMakeReference);
                checkData(carYearData,carYearReference);
                checkData(carYearData,addressReference);

                progressBar.setVisibility(View.VISIBLE);

                //Register the user in firebase
                firebaseAuth.createUserWithEmailAndPassword(emailData,passwordData).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            //Send verification link
                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                            firebaseUser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Register.this, "Verification Email Has been Sent.", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: Email not sent " + e.getMessage());
                                }
                            });

                            Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();

                            //Storing the user data inside the firebase
                            userID = firebaseAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = firebaseStore.collection("users").document(userID);
                            Map<String,Object> user = new HashMap<>();
                            user.put("name",fullNameData);
                            user.put("email",emailData);
                            user.put("phone",phoneData);
                            user.put("address",addressData);
                            user.put("carModel",carModelData);
                            user.put("carMake",carMakeData);
                            user.put("carYear",carYearData);

                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "onSuccess: user Profile is created for "+ userID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: " + e.toString());
                                }
                            });

                            //Sending data to the post method to send the data to the webserver
                            String[] userInformation = {firebaseUser.getUid(),fullNameData,emailData,phoneData,addressData,carMakeData,carModelData,carYearData};
                            post.sendUserRequest(userInformation);

                            //Switch to main activity
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else {
                            Toast.makeText(Register.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        //If the user selects the login button, redirect the user to the login view
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });
    }
}
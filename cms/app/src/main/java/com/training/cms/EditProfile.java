package com.training.cms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.training.logic.POST;

import java.util.HashMap;
import java.util.Map;
public class EditProfile extends AppCompatActivity {

    public static final String TAG = "TAG";
    //Defining references to the view components
    private EditText profileFullName,profileEmail,profilePhone,profileAddress,profileCarModel,profileCarMake,profileCarYear;
    private ImageView profileImageView;
    private Button saveBtn;
    //Defining the needed objects for the firebase operations
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseStore;
    private FirebaseUser firebaseUser;
    //Defining te POST object to connect to the server
    private POST post;

    //Starting point
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        //Initializing the objects
        post = new POST(this);

        Intent data = getIntent();
        final String fullNameData = data.getStringExtra("fullName");
        final String emailData = data.getStringExtra("email");
        final String phoneData = data.getStringExtra("phone");
        final String addressData = data.getStringExtra("address");
        final String carModelData = data.getStringExtra("carModel");
        final String carMakeData = data.getStringExtra("carMake");
        final String carYearData = data.getStringExtra("carYear");
        //String updatedFullNameData,updatedEmailData,updatedPhoneData,

        //Firebase
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseStore = FirebaseFirestore.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        //Text references
        profileFullName = findViewById(R.id.profileFullName);
        profileEmail = findViewById(R.id.profileEmail);
        profilePhone = findViewById(R.id.profilePhone);
        profileAddress = findViewById(R.id.profileAddress);
        profileCarModel = findViewById(R.id.profileCarModel);
        profileCarMake = findViewById(R.id.profileCarMake);
        profileCarYear = findViewById(R.id.profileCarYear);
        //Button
        saveBtn = findViewById(R.id.saveProfileInfo);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Checking if one of the new data is empty
                if(profileFullName.getText().toString().isEmpty() || profileEmail.getText().toString().isEmpty() || profilePhone.getText().toString().isEmpty() ||
                        profileCarModel.getText().toString().isEmpty() || profileCarMake.getText().toString().isEmpty() || profileCarYear.getText().toString().isEmpty()
                        || profileAddress.getText().toString().isEmpty()){
                    Toast.makeText(EditProfile.this, "One or Many fields are empty.", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Get the user email and update his information
                final String email = profileEmail.getText().toString();
                firebaseUser.updateEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        DocumentReference docRef = firebaseStore.collection("users").document(firebaseUser.getUid());
                        //Updated data
                        Map<String,Object> edited = new HashMap<>();
                        edited.put("email",email);
                        edited.put("name",profileFullName.getText().toString());
                        edited.put("phone",profilePhone.getText().toString());
                        edited.put("address",profileAddress.getText().toString());
                        edited.put("carModel",profileCarModel.getText().toString());
                        edited.put("carMake",profileCarMake.getText().toString());
                        edited.put("carYear",profileCarYear.getText().toString());
                        String[] userInformation = {firebaseUser.getUid(),
                                                    edited.get("name").toString(),edited.get("email").toString(),edited.get("phone").toString(),edited.get("address").toString(),
                                                    edited.get("carMake").toString(),edited.get("carModel").toString(),edited.get("carYear").toString()
                        };
                        //Sending the updated data of the user to the web server
                        post.sendUserRequest(userInformation);
                        //Update document
                        docRef.update(edited).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(EditProfile.this, "Profile Updated", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                finish();
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(EditProfile.this,   e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        //Can be removed
        profileEmail.setText(emailData);
        profileFullName.setText(fullNameData);
        profilePhone.setText(phoneData);
        profileAddress.setText(addressData);
        profileCarModel.setText(carModelData);
        profileCarMake.setText(carMakeData);
        profileCarYear.setText(carYearData);

        Log.d(TAG, "onCreate: " + fullNameData + " " + emailData + " " + phoneData);
    }

}
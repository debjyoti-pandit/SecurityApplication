package com.example.debjyotipandit.wawasan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import bean.OwnerBean;

public class OwnerRegistrationActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference();
    private RadioGroup radioSexGroup;
    private Button btnDisplay;
    private RadioButton radioSexButton;
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPhoneNumber;
    private EditText editTextPassword;
    private EditText editTextFlatNumber;
    private EditText editTextBlockNumber;
    private EditText editTextAddress;
    private EditText editTextVehicleId;
    private EditText editTextParkingId;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_registration);
        initialize();
        societySpinnerInitializer();
    }


    private void initialize() {
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextFlatNumber = findViewById(R.id.editTextFlatNumber);
        editTextBlockNumber = findViewById(R.id.editTextBlockNumber);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextVehicleId = findViewById(R.id.editTextVehicleId);
        editTextParkingId = findViewById(R.id.editTextParkingId);
        radioSexGroup = findViewById(R.id.radioSex);
        btnDisplay = findViewById(R.id.submit);
    }

    private void societySpinnerInitializer() {
        myRef.child("community").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final ArrayList<String> societyList = new ArrayList<>();
                for (DataSnapshot addressSnapshot : dataSnapshot.getChildren()) {
                    String societyName = addressSnapshot.child("societyName").getValue(String.class);
                    if (societyName != null) {
                        societyList.add(societyName);
                    }
                }
                spinner = (Spinner) findViewById(R.id.spinner);
                ArrayAdapter<String> societyAdapter = new ArrayAdapter<String>(OwnerRegistrationActivity.this, android.R.layout.simple_spinner_item, societyList);
                societyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(societyAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void registerController(View view) {

        int selectedId = radioSexGroup.getCheckedRadioButtonId();
        radioSexButton = (RadioButton) findViewById(selectedId);
        final OwnerBean newOwner = new OwnerBean(editTextName.getText().toString(),
                editTextEmail.getText().toString(),
                radioSexButton.getText().toString(),
                editTextPhoneNumber.getText().toString(),
                editTextPassword.getText().toString(),
                editTextFlatNumber.getText().toString(),
                editTextBlockNumber.getText().toString(),
                editTextAddress.getText().toString(),
                editTextVehicleId.getText().toString(),
                editTextParkingId.getText().toString());

        String spinnerValue = spinner.getSelectedItem().toString();
        Query query = myRef.child("community").orderByChild("societyName").equalTo(spinnerValue);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    String key = child.getKey();
                    Toast.makeText(OwnerRegistrationActivity.this, "Key: "+key, Toast.LENGTH_SHORT).show();
                    newOwner.setCommunityId(key);
                    Toast.makeText(OwnerRegistrationActivity.this, "Key: "+newOwner.getCommunityId(), Toast.LENGTH_SHORT).show();
                    myRef.child("owner").push().setValue(newOwner);
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
//                    Intent intent = new Intent(getBaseContext(), OwnerDashboard.class);
//                    intent.putExtra("sessionData",newOwner);
//                    startActivity(intent);
                    //insert intent for successfull login here
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}

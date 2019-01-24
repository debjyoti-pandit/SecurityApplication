package com.example.firebaseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MaidRegistrationActivity extends AppCompatActivity {

    private OwnerBean sessionData;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference();
    private RadioGroup radioSexGroup;
    private Button btnDisplay;
    private RadioButton radioSexButton;
    private EditText editTextName;
    private EditText editTextPhoneNumber;
    private EditText editTextPassword;
    private EditText editTextAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maid_registration);
        initSessionData();
    }

    private void initialize() {
        editTextName = (EditText) findViewById(R.id.maidEditTextName);
        editTextPhoneNumber = (EditText) findViewById(R.id.maidEditTextPhoneNumber);
        editTextPassword = (EditText) findViewById(R.id.maidEditTextPassword);
        editTextAddress = (EditText) findViewById(R.id.maidEditTextAddress);
        radioSexGroup = (RadioGroup) findViewById(R.id.maidRadioSex);
        btnDisplay = (Button) findViewById(R.id.submit);
    }

    private void initSessionData() {
        Intent i = getIntent();
        sessionData = (OwnerBean)i.getSerializableExtra("sessionData");
    }

    public void maidRegisterController(View view) {
        int selectedId = radioSexGroup.getCheckedRadioButtonId();
        radioSexButton = (RadioButton) findViewById(selectedId);
        final MaidBean newMaid = new MaidBean(editTextName.getText().toString(),
                radioSexButton.getText().toString(),
                editTextPhoneNumber.getText().toString(),
                editTextPassword.getText().toString(),
                editTextAddress.getText().toString(),
                "021121");

        Query query = myRef.child("owner").orderByChild("flatNumber").equalTo(sessionData.getFlatNumber());

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    String key = child.getKey();
                    Toast.makeText(MaidRegistrationActivity.this, "Key: "+key, Toast.LENGTH_SHORT).show();
                    newMaid.setOwnerId(key);
                    Toast.makeText(MaidRegistrationActivity.this, "Key: "+newMaid.getOwnerId(), Toast.LENGTH_SHORT).show();
                    myRef.child("maid").push().setValue(newMaid);
                    finish();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}

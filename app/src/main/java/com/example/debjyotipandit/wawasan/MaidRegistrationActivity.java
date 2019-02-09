package com.example.debjyotipandit.wawasan;

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

import bean.MaidBean;
import bean.OwnerBean;
import bean.SendTextMessage;

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
        initialize();
        initSessionData();
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maidRegisterController(v);
            }
        });
    }

    private void initialize() {
        editTextName = findViewById(R.id.maidEditTextName);
        editTextPhoneNumber = findViewById(R.id.maidEditTextPhoneNumber);
        editTextPassword = findViewById(R.id.maidEditTextPassword);
        editTextAddress = findViewById(R.id.maidEditTextAddress);
        radioSexGroup = findViewById(R.id.maidRadioSex);
        btnDisplay = findViewById(R.id.maidRegistrationButton);
    }

    private void initSessionData() {
        Intent i = getIntent();
        sessionData = (OwnerBean)i.getSerializableExtra("sessionData");
    }

    public void maidRegisterController(View view) {
        int selectedId = radioSexGroup.getCheckedRadioButtonId();
        radioSexButton = (RadioButton) findViewById(selectedId);
        final int randomNumber = SendTextMessage.getRandom();
        final MaidBean newMaid = new MaidBean(editTextName.getText().toString(),
                radioSexButton.getText().toString(),
                editTextPhoneNumber.getText().toString(),
                editTextPassword.getText().toString(),
                editTextAddress.getText().toString(),
                String.valueOf(randomNumber));
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

                    SendTextMessage.sendMessage("Please show the OTP while entering: "+String.valueOf(randomNumber),editTextPhoneNumber.getText().toString(),getApplicationContext());
                    Intent intent = new Intent(getApplicationContext(),OwnerDashboard.class);
                    startActivity(intent);
                    finish();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

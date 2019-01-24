package com.example.debjyotipandit.wawasan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import bean.CommunityBean;
import bean.Message;

public class CommunityRegistration extends AppCompatActivity {

    private EditText societyName, societyPhone, societyAddressLine1, societyAddressLine2, societyEntryGates, societyExitGates, societyFlats;
    private Button registerButton;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_registration);
        societyName  = findViewById(R.id.societyName);
        societyPhone  = findViewById(R.id.communityPhoneNumber);
        societyAddressLine1  = findViewById(R.id.communityAddress1);
        societyAddressLine2  = findViewById(R.id.communityAddress2);
        societyEntryGates  = findViewById(R.id.communityEntryGates);
        societyExitGates  = findViewById(R.id.communityExitGates);
        societyFlats = findViewById(R.id.societyFlats);
        registerButton = findViewById(R.id.registerCommunity);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommunityBean communityBean = new CommunityBean();
                communityBean.setSocietyName(societyName.getText().toString());
                communityBean.setPhoneNumber(Long.parseLong(societyPhone.getText().toString()));
                communityBean.setAddressLine1(societyAddressLine1.getText().toString());
                communityBean.setAddressLine2(societyAddressLine2.getText().toString());
                communityBean.setNoOfEntryGates(Integer.parseInt(societyEntryGates.getText().toString()));
                communityBean.setNoOfFlats(Integer.parseInt(societyExitGates.getText().toString()));
                communityBean.setNoOFExitGates(Integer.parseInt(societyFlats.getText().toString()));
                addCommunityToDb(communityBean);
            }
        });
    }

    private void addCommunityToDb(CommunityBean communityBean){
        mDatabase.child(getString(R.string.communityCollectionName)).push().setValue(communityBean);
        Message.message(getApplicationContext(),"Community successfully added");
    }
}

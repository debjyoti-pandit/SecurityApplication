package com.example.firebaseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OwnerDashboard extends AppCompatActivity {

    private OwnerBean sessionData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_dashboard);
        initSessionData();
    }

    private void initSessionData() {
        Intent i = getIntent();
        sessionData = (OwnerBean)i.getSerializableExtra("sessionData");
    }

    public void maidRegistrationForm(View view) {
        Intent intent = new Intent(getBaseContext(), MaidRegistrationActivity.class);
        intent.putExtra("sessionData",sessionData);
        startActivity(intent);
    }
}

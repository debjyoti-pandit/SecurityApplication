package com.example.debjyotipandit.wawasan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import bean.OwnerBean;

public class OwnerDashboard extends AppCompatActivity {

    private OwnerBean sessionData;
    private Button maidRegisterBtn, addFood, addVisitors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_dashboard);
        initSessionData();
        maidRegisterBtn = findViewById(R.id.maidRegistrationForm);
        addFood = findViewById(R.id.ownerAddFood);
        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),FoodDelivery.class);
                startActivity(i);
            }
        });
        addVisitors = findViewById(R.id.ownerAddVisitors);
        addVisitors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),VisitorsPass.class);
                startActivity(i);

            }
        });

        maidRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maidRegistrationForm(v);
            }
        });
    }

    private void initSessionData() {

        Intent i = getIntent();
        sessionData = (OwnerBean)i.getSerializableExtra("sessionData");
    }

    public void maidRegistrationForm(View view) {
        Intent intent = new Intent(getBaseContext(), MaidRegistrationActivity.class);
        intent.putExtra("sessionData",sessionData);
        startActivity(intent);
        finish();
    }

}

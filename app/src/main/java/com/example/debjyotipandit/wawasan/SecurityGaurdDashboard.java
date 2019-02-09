package com.example.debjyotipandit.wawasan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecurityGaurdDashboard extends AppCompatActivity {

    private Button maid, visitors, foodDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_gaurd_dashboard);

        maid = findViewById(R.id.sgMaidOTP);
        visitors = findViewById(R.id.sgVisitors);
        foodDel = findViewById(R.id.sgFoodDelivery);

        maid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SecurityMaidOTP.class);
                startActivity(i);
            }
        });
        visitors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SecurityVisitorsOTP.class);
                startActivity(i);
            }
        });
        foodDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SecurityFoodDelOTP.class);
                startActivity(i);
            }
        });



    }
}

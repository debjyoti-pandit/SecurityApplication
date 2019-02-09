package com.example.debjyotipandit.wawasan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import bean.Message;
import bean.SendTextMessage;
import bean.VisitorBean;

public class VisitorsPass extends AppCompatActivity {

    private EditText vName, vTime, vDate, vPeople, vMobile;
    private Button vBtn;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitors_pass);

        vName = findViewById(R.id.visitorPassVName);
        vTime = findViewById(R.id.visitorPassTime);
        vDate = findViewById(R.id.visitorPassDate);
        vPeople = findViewById(R.id.visitorPassNoOfPEople);
        vMobile = findViewById(R.id.visitorPassMobileNumber);

        vBtn = findViewById(R.id.visitorPassBtn);
        vBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VisitorBean visitorBean = new VisitorBean();
                visitorBean.setOwnerId("dev");
                visitorBean.setVisitorName(vName.getText().toString());
                visitorBean.setMobileNumber(Long.parseLong(vMobile.getText().toString()));
                visitorBean.setNofPeople(Integer.parseInt(vPeople.getText().toString()));
                try {
                    Message.message(getApplicationContext(),vTime.getText().toString());
                    Message.message(getApplicationContext(),vDate.getText().toString());
                    visitorBean.setTime(new SimpleDateFormat("HH:mm").parse(vTime.getText().toString()));
                    visitorBean.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(vDate.getText().toString()));
                    visitorBean.setOtpGenerated(SendTextMessage.getRandom());
                    SendTextMessage.sendMessage(formResponse(visitorBean),String.valueOf(visitorBean.getMobileNumber()),getApplicationContext());
                    addVisitorsToDb(visitorBean);
                    Intent i = new Intent(getApplicationContext(),OwnerDashboard.class);
                    startActivity(i);
                    finish();
                } catch (ParseException e) {
                    Message.message(getApplicationContext(),getText(R.string.dateFormatWrong).toString());
                }

            }

            private String formResponse(VisitorBean visitorBean) {
                return "Hi "+visitorBean.getVisitorName()+". You are invited by Debjyoti at his place. Your OTP is "+visitorBean.getOtpGenerated()+". Please show this OTP while entering.";
            }
        });

    }
    private void addVisitorsToDb(VisitorBean visitorBean){
        mDatabase.child(getString(R.string.visitorsCollectionName)).push().setValue(visitorBean);
        Message.message(getApplicationContext(),"Visitors successfully added");
    }
}

package com.example.debjyotipandit.wawasan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import bean.FoodDeliveryBean;
import bean.Message;


public class FoodDelivery extends AppCompatActivity {
    private DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
    private EditText odNo, odMer, odTime, odDate;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private String deliveryOption;
    private Button btn;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_food_delivery);

        radioGroup = findViewById(R.id.foodDeliveryRadioGrp);
        btn = findViewById(R.id.foodDeliveryBtn);

        odNo = findViewById(R.id.orderNumber);
        odMer = findViewById(R.id.orderMerchant);
        odTime = findViewById(R.id.foodIntime);
        odDate = findViewById(R.id.foodInDate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FoodDeliveryBean foodDeliveryBean = new FoodDeliveryBean();
                foodDeliveryBean.setDeliveryOption(deliveryOption);
                foodDeliveryBean.setInDate(odDate.getText().toString());
                foodDeliveryBean.setInTime(odTime.getText().toString());
                foodDeliveryBean.setOrderNumber(odNo.getText().toString());
                foodDeliveryBean.setOrderVendor(odMer.getText().toString());
                addFoodToDB(foodDeliveryBean);
                Intent i = new Intent(getApplicationContext(),OwnerDashboard.class);
                startActivity(i);
                finish();

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = group.findViewById(checkedId);
                deliveryOption = radioButton.getText().toString();
            }
        });
    }
    private void addFoodToDB(FoodDeliveryBean foodDeliveryBean) {
        mDatabase.child(getString(R.string.foodDelCollectionName)).push().setValue(foodDeliveryBean);
        Message.message(getApplicationContext(),"Food delivery details added successfully");
    }

}

package com.example.debjyotipandit.wawasan;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import bean.FoodDeliveryBean;
import bean.Message;

public class SecurityFoodDelOTP extends AppCompatActivity {

    private EditText orderNumber;
    private Button validate;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_food_del_otp);
        orderNumber = findViewById(R.id.secFoodOrderNUmber);
        validate = findViewById(R.id.secFoodCheck);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Query query = mDatabase.child(getString(R.string.foodDelCollectionName)).orderByChild("orderNumber").equalTo(orderNumber.getText().toString());
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        FoodDeliveryBean foodDeliveryBean;
                        if(dataSnapshot.exists()){
                            for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                                foodDeliveryBean = singleSnapshot.getValue(FoodDeliveryBean.class);
                                Message.message(getApplicationContext(),"You have a order having this instruction: "+foodDeliveryBean.getDeliveryOption());
                            }

                            Intent i = new Intent(getApplicationContext(),SecurityGaurdDashboard.class);
                            startActivity(i);
                            finish();
                        }else {
                            Message.message(getApplicationContext(),"Sorry there is no such order");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}

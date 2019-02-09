package com.example.debjyotipandit.wawasan;

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

import bean.MaidBean;
import bean.Message;
import bean.VisitorBean;

public class SecurityMaidOTP extends AppCompatActivity {

    private EditText phone, otp;
    private Button validate;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecurity_maid_otp);

        phone = findViewById(R.id.secMaidPhone);
        otp = findViewById(R.id.secMaidOTP);
        validate = findViewById(R.id.secMaidCheck);

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Query query = mDatabase.child(getString(R.string.maidCollectionName)).orderByChild("phoneNumber").equalTo(phone.getText().toString());
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                            Message.message(getApplicationContext(), "Before printing key");
                            Message.message(getApplicationContext(), singleSnapshot.getKey());
                            MaidBean maidBean = singleSnapshot.getValue(MaidBean.class);
                            Message.message(getApplicationContext(),String.valueOf(maidBean.getUniqueCode()));

//                            final View matched = findViewById(R.id.visitorsMatched);
//                            final View notMatched = findViewById(R.id.visitorsNotMatched);

                            if(Integer.parseInt(maidBean.getUniqueCode() )== Integer.parseInt(otp.getText().toString())){
                                Message.message(getApplicationContext(),"OTP matched");
                                otp.getText().clear();
                                phone.getText().clear();
//                                matched.setVisibility(View.VISIBLE);
//                                notMatched.setVisibility(View.INVISIBLE);
                            }else{
                                Message.message(getApplicationContext(),"Sorry! but the OTP didn't matched");
//                                matched.setVisibility(View.INVISIBLE);
//                                notMatched.setVisibility(View.VISIBLE);
                            }
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

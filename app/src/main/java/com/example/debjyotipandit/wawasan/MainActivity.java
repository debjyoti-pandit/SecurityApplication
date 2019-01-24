package com.example.debjyotipandit.wawasan;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import bean.AdminBean;
import bean.Message;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView registerText;
    private String spinnerSelected;
    private Button loginButton;
    private EditText email, password;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerText = findViewById(R.id.registerTV);

        final Spinner spinner = findViewById(R.id.loginSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.roleArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);

        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinnerSelected.equals("--Select--")){
                    Message.message(getApplicationContext(),getString(R.string.errorSelectSpinner));
                }else {
                    emailPassMatched();
                }
            }
        });

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VisitorsPass.class);
                startActivity(intent);
            }
        });
    }

    private void emailPassMatched() {
        String role = null;
        switch (spinnerSelected) {
            case "Owner":
                role = getString(R.string.communityCollectionName);
                break;
            case "Admin":
                role = getString(R.string.adminCollectionName);
                break;
            case "Security Gaurd":
                role = getString(R.string.communityCollectionName);
                break;
            default:
                Message.message(getApplicationContext(), getString(R.string.errorSelectSpinner));
        }
        Query query = mDatabase.child(role).orderByChild("email").equalTo(email.getText().toString());
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                AdminBean adminBean;
                Message.message(getApplicationContext(),"Before printing key");
                Message.message(getApplicationContext(),dataSnapshot.getKey());
                for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                    Message.message(getApplicationContext(),"Before printing key");
                    Message.message(getApplicationContext(),singleSnapshot.getKey());
                    switch (spinnerSelected) {
                        case "Owner":
                            adminBean = singleSnapshot.getValue(AdminBean.class);
                            break;
                        case "Admin":
                            adminBean = singleSnapshot.getValue(AdminBean.class);
                            if(adminBean.getEmail().equals(email.getText().toString()) && adminBean.getPassword().equals(password.getText().toString())){
                                Intent intent = new Intent(getApplicationContext(),AdminDashboard.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("adminName",adminBean.getName());
                                bundle.putString("adminID",singleSnapshot.getKey());
                                startActivity(intent,bundle);
                                finish();
                            }else {
                                Message.message(getApplicationContext(),getString(R.string.passMismatch));
                            }
                            break;
                        case "Security Gaurd":
                            adminBean = singleSnapshot.getValue(AdminBean.class);
                            break;
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("MAIN ACTIVITY ERROR", "onCancelled", databaseError.toException());
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerSelected = parent.getItemAtPosition(position).toString();
        Message.message(getApplicationContext(),parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        spinnerSelected = null;
        Message.message(getApplicationContext(),getString(R.string.errorSelectSpinner));
    }
}

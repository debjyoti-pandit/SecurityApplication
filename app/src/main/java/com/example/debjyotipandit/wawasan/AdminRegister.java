package com.example.debjyotipandit.wawasan;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import bean.AdminBean;
import bean.Message;

public class AdminRegister extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 10;
    private StorageReference mStorageRef = FirebaseStorage.getInstance().getReference();
    private StorageReference imagesRef = mStorageRef.child("images");
    private Button registerAdmin,chooseImage;
    private ImageView imageView;
    private Uri filePath;
    private EditText name, address, email, phone, password, confirmPassword;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private String gender;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);
        
        societySpinnerInitializer();
        
        chooseImage = findViewById(R.id.imageChooseButton);
        registerAdmin = findViewById(R.id.registerAdminButton);
        imageView = findViewById(R.id.adminImagePreview);

        name = findViewById(R.id.adminName);
        address = findViewById(R.id.adminAddress);
        email = findViewById(R.id.adminEmail);
        phone = findViewById(R.id.adminMobileNumber);
        password = findViewById(R.id.adminPassword);
        confirmPassword = findViewById(R.id.adminConfirmPassword);
        radioGroup = findViewById(R.id.adminRadioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = group.findViewById(checkedId);
                gender = radioButton.getText().toString();
            }
        });

        chooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
            private void chooseImage() {
                Intent  intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select a picture"),PICK_IMAGE_REQUEST);
            }
        });
        registerAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(confirmPassword.getText().toString().equals(password.getText().toString())){
                    String imageId = UUID.randomUUID().toString();

                    AdminBean adminBean = new AdminBean();
                    adminBean.setAddress(address.getText().toString());
                    adminBean.setEmail(email.getText().toString());
                    adminBean.setImageID(imageId);
                    adminBean.setName(name.getText().toString());
                    adminBean.setPassword(password.getText().toString());
                    adminBean.setPhoneNumber(Long.parseLong(phone.getText().toString()));
                    adminBean.setGender(gender);
                    
                    String spinnerValue = spinner.getSelectedItem().toString();
                    Query query = myRef.child("community").orderByChild("societyName").equalTo(spinnerValue);
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot child : dataSnapshot.getChildren()) {
                                String key = child.getKey();
                                adminBean.setCommunityID(key);
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                    
                    uploadImage(imageId,adminBean);


                }else{
                    Message.message(getApplicationContext(),"Password and Confirm Password didn't matched");
                }

            }
        });
    }
    
    private void societySpinnerInitializer() {
        myRef.child("community").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final ArrayList<String> societyList = new ArrayList<>();
                for (DataSnapshot addressSnapshot : dataSnapshot.getChildren()) {
                    String societyName = addressSnapshot.child("societyName").getValue(String.class);
                    if (societyName != null) {
                        societyList.add(societyName);
                    }
                }
                spinner = (Spinner) findViewById(R.id.spinner);
                ArrayAdapter<String> societyAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, societyList);
                societyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(societyAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void addAdminToDB(AdminBean adminBean) {
        mDatabase.child(getString(R.string.adminCollectionName)).push().setValue(adminBean);
        Message.message(getApplicationContext(),"Admin successfully registered");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            filePath = data.getData();
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),filePath);
                imageView.setImageBitmap(bitmap);
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    private void uploadImage(String imageId, final  AdminBean adminBean) {
        if(filePath != null){
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading Image...");
            progressDialog.show();
            StorageReference image = imagesRef.child(imageId);
            image.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            addAdminToDB(adminBean);
                            Message.message(getApplicationContext(),getString(R.string.imageUploadSuccess));
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                            finish();

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Message.message(getApplicationContext(),getString(R.string.errorImageupload));
                        }
                    }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    double progress = ((100.0) * taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                    progressDialog.setMessage("Uploading ... "+String.valueOf(progress)+"%");
                }
            });
        }else {
            Message.message(getApplicationContext(),getText(R.string.errorSelectImage).toString());
        }
    }
}

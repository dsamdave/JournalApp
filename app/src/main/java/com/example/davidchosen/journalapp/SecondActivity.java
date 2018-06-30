package com.example.davidchosen.journalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Davidchosen on 29/06/2018.
 */

public class SecondActivity extends AppCompatActivity{

    ImageView imageView;
    TextView textName, textEmail;
    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceSate) {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.second_activity);


        mAuth = FirebaseAuth.getInstance();

        imageView = findViewById(R.id.imageview);
        textName = findViewById(R.id.textViewName);
        textEmail = findViewById(R.id.textViewEmail);


        FirebaseUser user = mAuth.getCurrentUser();

        Glide.with(this)
                .load(user.getPhotoUrl())
                .into(imageView);


        textName.setText(user.getDisplayName());
        textEmail.setText(user.getEmail());




    }


    @Override
    protected void onStart () {
        super.onStart();
        if(mAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, MainActivity.class ));
        }

    }


}





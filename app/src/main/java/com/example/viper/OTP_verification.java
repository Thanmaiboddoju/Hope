package com.example.viper;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class OTP_verification extends AppCompatActivity {
    Button  _btnVerOTP;
    EditText _txtVerOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        String name=getIntent().getStringExtra("name");
        String mobile=getIntent().getStringExtra("phone");
        int randomNumber=getIntent().getIntExtra("OTP",0);
        _txtVerOTP = (EditText) findViewById(R.id.editTextTextPostalAddress);
        _btnVerOTP = (Button) findViewById(R.id.button);
        _btnVerOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (randomNumber == Integer.valueOf(_txtVerOTP.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(OTP_verification.this,HomePage.class);
                    intent.putExtra("name",name);
                    intent.putExtra("phone",mobile);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong OTP", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
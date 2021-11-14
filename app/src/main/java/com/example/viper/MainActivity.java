package com.example.viper;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button _btnGetOTP;
    EditText _txtName, _txtPhone;
    int randomNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _txtName = (EditText) findViewById(R.id.editTextTextPersonName);
        _txtPhone = (EditText) findViewById(R.id.editTextPhone);
        _btnGetOTP = (Button) findViewById(R.id.button2);
        _btnGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                        sendOTP();
                        Intent intent = new Intent(MainActivity.this,OTP_verification.class);
                        intent.putExtra("name",_txtName.getText().toString());
                        intent.putExtra("phone",_txtPhone.getText().toString().trim());
                        intent.putExtra("OTP",randomNumber);
                        startActivity(intent);
                    } else {
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 1);
                    }
                }
            }
        });

    }

    private void sendOTP() {
        Random random = new Random();
        randomNumber = random.nextInt(999999);
        String mobile = _txtPhone.getText().toString().trim();
        String message = "Hello " + _txtName.getText().toString() + "\nYour OTP is : " + randomNumber;

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(mobile, null, message, null, null);
            Toast.makeText(getApplicationContext(), "OTP sent successfully", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "ERROR" + e, Toast.LENGTH_LONG).show();
            //System.out.println("Error SMS "+e);
            //return "Error "+e;
        }

    }
}
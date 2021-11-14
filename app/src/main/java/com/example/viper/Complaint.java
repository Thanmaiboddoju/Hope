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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class Complaint extends AppCompatActivity {
    Button _btnProbSub;
    EditText _txtContext;
    CheckBox _terms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3);
        _btnProbSub = (Button) findViewById(R.id.button3);
        _txtContext = (EditText) findViewById(R.id.editTextTextMultiLine);
        _terms = (CheckBox) findViewById(R.id.checkBox);
        _btnProbSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (_terms.isChecked()) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                            sendThank();
                            sendDetails();
                            Intent intent = new Intent(Complaint.this, thankyou.class);
                            startActivity(intent);
                        } else {
                            requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 1);
                        }
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please accept terms and conditions",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
        public void sendThank(){
        String mobile=getIntent().getStringExtra("phone");
        String name=getIntent().getStringExtra("name");
        String message = "Hello "+name+"\nThank you for choosing our platform. We will reach you shortly.If its emergency, Dont panic, go to nearby police station and give a complaint  ";
        try{
            SmsManager smsManager=SmsManager.getDefault();
            smsManager.sendTextMessage(mobile,null,message,null,null);
            Toast.makeText(getApplicationContext(),"Your message sent successfully",Toast.LENGTH_LONG).show();



        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(),"ERROR"+e,Toast.LENGTH_LONG).show();
        }

    }
    private void sendDetails(){
        String ownMobile="8309112088";
        String mobile=getIntent().getStringExtra("phone");
        String name=getIntent().getStringExtra("name");
        try{
            SmsManager smsManager=SmsManager.getDefault();
            smsManager.sendTextMessage(ownMobile,null,"Name:"+name+"\nMobile no: "+mobile+"\nProblemStatement:"+_txtContext.getText().toString(),null,null);
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(),"ERROR"+e,Toast.LENGTH_LONG).show();
            //System.out.println("Error SMS "+e);
            //return "Error "+e;
        }

    }
}
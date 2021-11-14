package com.example.viper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class thankyou extends AppCompatActivity {
    Button _btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);
        _btnHome=(Button) findViewById(R.id.button5);
        _btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thankyou.this,HomePage.class);
                startActivity(intent);
            }
        });
    }
}
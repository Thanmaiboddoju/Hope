package com.example.viper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {
    Button _btnComplaint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String name=getIntent().getStringExtra("name");
        String mobile=getIntent().getStringExtra("phone");
        _btnComplaint = (Button) findViewById(R.id.button4);
        _btnComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(HomePage.this,Complaint.class);
                    intent.putExtra("name",name);
                    intent.putExtra("phone",mobile);
                    startActivity(intent);
                }
        });
    }

}
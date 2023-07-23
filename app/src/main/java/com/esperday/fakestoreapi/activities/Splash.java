package com.esperday.fakestoreapi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.esperday.fakestoreapi.R;
import com.esperday.fakestoreapi.utils.SessionManger;

public class Splash extends AppCompatActivity {

    Button btnSplash;
    SessionManger sessionManger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sessionManger = new SessionManger(getApplicationContext());
        sessionManger.revisarAcceso();
        btnSplash = findViewById(R.id.btnSplash);

        btnSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Splash.this, Acceso.class));
            }
        });
    }
}
package com.esperday.fakestoreapi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.esperday.fakestoreapi.R;
import com.esperday.fakestoreapi.utils.SessionManger;

public class Menu extends AppCompatActivity {

    Button btnSalir;
    TextView txtToken;
    SessionManger sessionManger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        sessionManger = new SessionManger(getApplicationContext());
        sessionManger.revisarAcceso();
        btnSalir = findViewById(R.id.btnSalir);
        txtToken = findViewById(R.id.txtToken);

        Intent intent = getIntent();
        String name = intent.getStringExtra("obtenertoken");
        txtToken.setText(name);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManger.logOut();
            }
        });
    }
}
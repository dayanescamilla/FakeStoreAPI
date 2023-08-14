package com.esperday.fakestoreapi.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.hardware.biometrics.BiometricPrompt;
import android.os.Bundle;

import com.esperday.fakestoreapi.R;

public class HuellaDigital extends AppCompatActivity {

    BiometricPrompt biometricPrompt;
    BiometricPrompt.Builder builder;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huella_digital);

        constraintLayout = findViewById(R.id.layout_bio);


    }
}
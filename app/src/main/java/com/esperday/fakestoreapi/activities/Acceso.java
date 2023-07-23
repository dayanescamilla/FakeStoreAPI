package com.esperday.fakestoreapi.activities;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.esperday.fakestoreapi.R;
import com.esperday.fakestoreapi.api.RetrofitClient;
import com.esperday.fakestoreapi.api.WebService;
import com.esperday.fakestoreapi.dto.AccesoDTO;
import com.esperday.fakestoreapi.dto.RespuestaAccesoDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Acceso extends AppCompatActivity {

    EditText editUsuario, editPassword;
    Button btnEntrar;
    private static String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso);

        editUsuario = findViewById(R.id.editUser);
        editPassword = findViewById(R.id.editPassword);

        btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarDatos();
            }
        });
    }

    private void validarDatos() {
        String usuario = editUsuario.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        if (!TextUtils.isEmpty(usuario) && !TextUtils.isEmpty(password)){
            Login();
        }else{
            if (TextUtils.isEmpty(usuario)){
                Toast.makeText(this, "Falta usuario", Toast.LENGTH_SHORT).show();
            }if (TextUtils.isEmpty(password)){
                Toast.makeText(this, "Falta Contra", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void Login() {
        final AccesoDTO accesoDTO = new AccesoDTO(editUsuario.getText().toString(), editPassword.getText().toString());
        Call<RespuestaAccesoDTO> call = RetrofitClient.getWS().getAcceso(accesoDTO);

        call.enqueue(new Callback<RespuestaAccesoDTO>() {
            @Override
            public void onResponse(Call<RespuestaAccesoDTO> call, Response<RespuestaAccesoDTO> response) {
                if (response.isSuccessful() && response.code() == 200 && response.body() != null){
                    Log.e(TAG, "onResponse: "+response.body().getToken());
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            token = response.body().getToken();
                            startActivity(new Intent(Acceso.this, Menu.class).putExtra("obtenertoekn",token));
                            finish();
                        }
                    },700);
                }else {
                    Log.e(TAG, "onResponse: "+response.code());
                }
            }

            @Override
            public void onFailure(Call<RespuestaAccesoDTO> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}
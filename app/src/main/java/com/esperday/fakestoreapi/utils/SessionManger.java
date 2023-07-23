package com.esperday.fakestoreapi.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.esperday.fakestoreapi.activities.Acceso;
import com.esperday.fakestoreapi.activities.Splash;
import com.esperday.fakestoreapi.dto.AccesoDTO;

public class SessionManger {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context ctx;
    int private_mode = 0;

    private static final String PREF_NAME = "PreferenciasSesion";
    private static final String IS_LOGIN = "isLoggedIn";
    private  static final String KEY_USERNAME = "username";
    private  static final String KEY_PASSWORD = "password";

    public SessionManger(Context context){
        this.ctx = context;
        preferences = ctx.getSharedPreferences(PREF_NAME, private_mode);
        editor = preferences.edit();
    }

    public void crearLoginSession(AccesoDTO accesoDTO){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_USERNAME, accesoDTO.getUsername());
        editor.putString(KEY_PASSWORD, accesoDTO.getPassword());
        editor.commit();
    }

    public boolean isLoggedIn(){
        return preferences.getBoolean(IS_LOGIN, false);
    }

    public void revisarAcceso(){
        if (!this.isLoggedIn()){
            Intent intent = new Intent(ctx, Acceso.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            ctx.startActivity(intent);
        }
    }

    public void logOut(){
        editor.clear();
        editor.commit();

        Intent intent = new Intent(ctx, Acceso.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        ctx.startActivity(intent);
    }
}

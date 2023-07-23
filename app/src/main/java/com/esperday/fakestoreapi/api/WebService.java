package com.esperday.fakestoreapi.api;

import com.esperday.fakestoreapi.dto.AccesoDTO;
import com.esperday.fakestoreapi.dto.RespuestaAccesoDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface WebService {

    @POST("auth/login")
    Call<RespuestaAccesoDTO> getAcceso(
            @Body AccesoDTO accesoDTO
    );

}

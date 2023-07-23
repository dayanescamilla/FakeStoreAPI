package com.esperday.fakestoreapi.dto;

public class RespuestaAccesoDTO {

    private String token;

    public RespuestaAccesoDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

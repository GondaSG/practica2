package com.client.exception;

public class ModelNotFoundException extends RuntimeException{
    public ModelNotFoundException(String mensaje){
        super(mensaje);
    }
}

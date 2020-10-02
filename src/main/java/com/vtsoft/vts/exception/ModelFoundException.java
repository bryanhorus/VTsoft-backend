package com.vtsoft.vts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class ModelFoundException extends RuntimeException {

    public ModelFoundException(String mensaje){
        super(mensaje);
    }
}

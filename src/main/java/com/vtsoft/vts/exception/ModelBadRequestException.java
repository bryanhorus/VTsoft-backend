package com.vtsoft.vts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ModelBadRequestException extends RuntimeException {

    public ModelBadRequestException(String mensaje){
        super(mensaje);
    }
}

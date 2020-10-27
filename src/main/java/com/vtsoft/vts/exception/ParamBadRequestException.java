package com.vtsoft.vts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ParamBadRequestException extends RuntimeException{

    public ParamBadRequestException(String mensaje){
        super(mensaje);
    }
}

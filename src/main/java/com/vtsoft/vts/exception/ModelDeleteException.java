package com.vtsoft.vts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class ModelDeleteException extends RuntimeException {
    public ModelDeleteException(String mensaje){
        super(mensaje);
    }
}

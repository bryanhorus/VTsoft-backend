package com.vtsoft.vts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class ListEmptyException extends RuntimeException {
    public ListEmptyException(String mensaje){
        super(mensaje);
    }
}

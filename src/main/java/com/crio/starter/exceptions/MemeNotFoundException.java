package com.crio.starter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MemeNotFoundException extends RuntimeException {
    public MemeNotFoundException(String message)
    {
        super(message);
    }
    
}

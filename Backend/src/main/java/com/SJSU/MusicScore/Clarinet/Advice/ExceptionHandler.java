package com.SJSU.MusicScore.Clarinet.Advice;

import com.SJSU.MusicScore.Clarinet.Exception.ClarinetException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ClarinetException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleClarinetException(ClarinetException ex){
        return ex.getMessage();
    }

}

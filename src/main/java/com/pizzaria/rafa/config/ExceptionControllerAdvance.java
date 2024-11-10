package com.pizzaria.rafa.config;

import com.pizzaria.rafa.data.response.ErroResponse;
import jakarta.persistence.NoResultException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionControllerAdvance {
    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResponse InputIncorreto(HttpMessageNotReadableException e){
        return new ErroResponse("X_100", "Preenchimento inválido, favor revisar");
    }

    @ResponseBody
    @ExceptionHandler(NoResultException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroResponse NotResult(NoResultException e){
        return new ErroResponse("X_200", e.getMessage());
    }
}

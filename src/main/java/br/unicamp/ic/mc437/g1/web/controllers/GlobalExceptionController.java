package br.unicamp.ic.mc437.g1.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Fernando H. S. Goncalves (fernando.goncalves@movile.com)
 */
@ControllerAdvice
public class GlobalExceptionController {

    private Logger logEx = LoggerFactory.getLogger("exceptions");

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleException(Exception e) {
        logEx.error("Catching 'IllegalArgumentException' = {}", e.getMessage(), e);
        return "error/error";
    }
}

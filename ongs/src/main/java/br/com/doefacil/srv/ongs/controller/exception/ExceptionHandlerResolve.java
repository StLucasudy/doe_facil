package br.com.doefacil.srv.ongs.controller.exception;

import br.com.doefacil.srv.ongs.service.exception.PassWordNotMatch;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ExceptionHandlerResolve {

    @ExceptionHandler(PassWordNotMatch.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(PassWordNotMatch ex) {
        return new ResponseEntity<>(
                new ErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        ex.getLocalizedMessage(),
                        Instant.now().toString()
                )
                , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(Exception ex) {
        return new ResponseEntity<>(
                new ErrorResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        ex.getLocalizedMessage(),
                        Instant.now().toString()
                )
                , HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

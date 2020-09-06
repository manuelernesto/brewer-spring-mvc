package io.github.manuelernesto.controller.handler;

import io.github.manuelernesto.service.exception.NomeJaCadastradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceExceptionHendler {

    @ExceptionHandler({NomeJaCadastradoException.class})
    public ResponseEntity<String> hendlerNomeJaCadastradoException(NomeJaCadastradoException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

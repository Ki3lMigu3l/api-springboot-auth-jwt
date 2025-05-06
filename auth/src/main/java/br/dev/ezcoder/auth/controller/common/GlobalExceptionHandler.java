package br.dev.ezcoder.auth.controller.common;

import br.dev.ezcoder.auth.controller.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse hanbleAccessDeniedException (AccessDeniedException exception) {
        return new ErrorResponse(HttpStatus.FORBIDDEN.value(), "Acesso negado", List.of());
    }
}

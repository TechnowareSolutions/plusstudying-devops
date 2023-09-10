package br.com.fiap.technoware.plusstudying.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.validation.ConstraintViolationException;
import br.com.fiap.technoware.plusstudying.model.RestValidationError;

@RestControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<RestValidationError>> constraintViolationExceptionHandler(ConstraintViolationException e) {
        List<RestValidationError> errors = new ArrayList<>();
        e.getConstraintViolations().forEach(violation -> {
            errors.add(new RestValidationError(violation.getPropertyPath().toString(), violation.getMessage()));
        }); 
        return ResponseEntity.badRequest().body(errors);
    }

    
}

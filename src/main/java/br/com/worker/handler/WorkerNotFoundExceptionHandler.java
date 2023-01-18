package br.com.worker.handler;

import br.com.worker.exceptions.WorkerNotFoundExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class WorkerNotFoundExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<WorkerNotFoundExceptionDetails> handler(EntityNotFoundException exception){
        return new ResponseEntity<>(
                WorkerNotFoundExceptionDetails.builder()
                        .title("Worker Not Found")
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.OK
        );
    }

}

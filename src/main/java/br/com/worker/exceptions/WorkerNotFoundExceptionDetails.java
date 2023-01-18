package br.com.worker.exceptions;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class WorkerNotFoundExceptionDetails {
    private String title;
    private LocalDateTime timestamp;
}

package dev.imrob.tutorialcrud.exceptions.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CustomError {
    private int status;
    private String message;
    private String timestamp;
    private String path;
}

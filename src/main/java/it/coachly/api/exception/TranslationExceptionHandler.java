package it.coachly.api.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@Slf4j
@RestControllerAdvice
public class TranslationExceptionHandler {

    @ExceptionHandler(TranslationNotFoundException.class)
    public ProblemDetail handleTranslationNotFound(TranslationNotFoundException ex) {
        log.warn("Translation not found: {}", ex.getMessage());

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );

        problemDetail.setTitle("Translation Not Found");
        problemDetail.setProperty("entityType", ex.getEntityType());
        problemDetail.setProperty("entityId", ex.getEntityId());
        problemDetail.setProperty("locale", ex.getLocale());
        problemDetail.setProperty("fieldName", ex.getFieldName());
        problemDetail.setProperty("timestamp", Instant.now());

        return problemDetail;
    }
}
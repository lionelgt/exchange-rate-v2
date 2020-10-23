package pe.com.bcp.exchangerate.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Calendar;


@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ExchangeRateResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    public ExchangeRateResponseEntityExceptionHandler() {
    }

    @ExceptionHandler(value = {IllegalArgumentException.class, NullPointerException.class})
    protected ResponseEntity<Object> handlerExceptionBadRequest(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handlerException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = "default";
        ExchangeRateResponseEntity<Object> responseEntity = new ExchangeRateResponseEntity();
        responseEntity.setTrackingId(Calendar.getInstance().getTimeInMillis());
        responseEntity.setMessage(message);
        responseEntity.setErrorCode(ex.getMessage());
        log.error("code: [{}] message: [{}]", responseEntity.getErrorCode(), responseEntity.getMessage(), ex);
        return new ResponseEntity<Object>(responseEntity, headers, status);
    }
}

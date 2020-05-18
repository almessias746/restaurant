package com.sioux.andre.messias.restaurant.exception;

import java.time.LocalDateTime;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class PocAndreMessiasExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException exception, HttpServletRequest request) {

        Locale locale = LocaleContextHolder.getLocale();
        Object[] args = new Object[] { exception.getName(), exception.getRequiredType().getName() };
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().timeStamp(LocalDateTime.now())
                .httpStatus(HttpStatus.BAD_REQUEST.value())
                .message(messageSource.getMessage("argument.type.mismatch", args, locale))
                .messageError(exception.getMessage()).path(request.getRequestURI()).build();

        log(request, exceptionResponse);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        Locale locale = LocaleContextHolder.getLocale();

        ExceptionResponse exceptionResponse = ExceptionResponse.builder().timeStamp(LocalDateTime.now())
                .httpStatus(HttpStatus.BAD_REQUEST.value())
                .message(messageSource.getMessage(exception.getBindingResult().getFieldErrors().get(0), locale))
                .messageNotTranslated(exception.getBindingResult().getFieldErrors().get(0).getField() + "_"
                        + exception.getBindingResult().getFieldErrors().get(0).getCode())
                .messageError(exception.getMessage()).path(request.getContextPath()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            final MissingServletRequestParameterException e, final HttpHeaders headers, final HttpStatus status,
            final WebRequest request) {
        Locale locale = LocaleContextHolder.getLocale();
        Object[] args = new Object[] { "error", e.getMessage() };
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().timeStamp(LocalDateTime.now())
                .httpStatus(HttpStatus.BAD_REQUEST.value())
                .message(messageSource.getMessage("argument.not.present", args, locale)).messageError(e.getMessage())
                .messageNotTranslated(e.getMessage()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    private void log(HttpServletRequest request, ExceptionResponse exceptionResponse) {
        logger.error("----------------------------------");
        logger.error("Error: " + exceptionResponse.getMessageError());
        if (request.getParameterMap() != null && !request.getParameterMap().isEmpty()) {
            logger.error("Parameters: ");
            request.getParameterMap().forEach((key, value) -> {
                logger.error(key + " = " + request.getParameter(key));
            });
        }
        logger.error("----------------------------------");
    }

}
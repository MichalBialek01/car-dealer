package pl.bialek.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import pl.bialek.domain.exception.ProcessingException;

import java.util.Optional;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        String message = String.format("Other exception occurred: [%s]", ex.getMessage());
        log.error(message, ex);
        ModelAndView modelView = new ModelAndView("error");
        modelView.addObject("errorMessage", message);
        return modelView;
    }

    @ExceptionHandler(ProcessingException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleException(ProcessingException processingException) {
        String message = String.format("ProcessingException occurred: [%s]", processingException.getMessage());
        log.error(message, processingException);
        ModelAndView modelView = new ModelAndView("error");
        modelView.addObject("errorMessage", message);
        return modelView;
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleException(BindException bindException) {
         String errorMessage = String.format("Bad request for field: {%s}, wrong value: {%s}",
                 Optional.ofNullable(bindException.getFieldError()).map(FieldError::getField).orElse(null),
                 Optional.ofNullable(bindException.getFieldError()).map(FieldError::getRejectedValue).orElse(null)
                 );
         log.error(errorMessage,bindException);
         ModelAndView modelAndView = new ModelAndView("error");
         modelAndView.addObject("errorMessage",errorMessage);
         return modelAndView;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        StringBuilder errorMessage = new StringBuilder("Validation failed for fields: ");

        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errorMessage.append(String.format("{%s} rejected value: {%s}; ",
                    fieldError.getField(),
                    fieldError.getRejectedValue()));
        });

        log.error(errorMessage.toString(), ex);

        ModelAndView modelView = new ModelAndView("error");
        modelView.addObject("errorMessage", errorMessage.toString());
        return modelView;
    }

}
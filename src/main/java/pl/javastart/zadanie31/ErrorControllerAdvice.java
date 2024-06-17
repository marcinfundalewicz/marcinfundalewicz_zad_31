package pl.javastart.zadanie31;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice {
    @ExceptionHandler(NoConnectionException.class)
    public String handleConnectionException() {
        return "noConnection";
    }

    @ExceptionHandler(CityNotFoundException.class)
    public String handleException() {
        return "noCity";
    }
}

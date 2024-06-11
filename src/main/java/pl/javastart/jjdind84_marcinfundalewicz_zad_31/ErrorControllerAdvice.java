package pl.javastart.jjdind84_marcinfundalewicz_zad_31;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(CityNotFoundException.class)
    public String handleException() {
        return "noCity";
    }
}

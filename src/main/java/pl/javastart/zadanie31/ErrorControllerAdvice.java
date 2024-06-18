package pl.javastart.zadanie31;

import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice {
    @ExceptionHandler(NoConnectionException.class)
    public String handleConnectionException(Model model) {
        model.addAttribute("error", "Błąd połączenia");
        return "mistake";
    }

    @ExceptionHandler(CityNotFoundException.class)
    public String handleException(Model model) {
        model.addAttribute("error", "Nie udało się znaleźć takiego miasta");
        return "mistake";
    }
}

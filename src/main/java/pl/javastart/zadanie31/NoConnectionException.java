package pl.javastart.zadanie31;

public class NoConnectionException extends RuntimeException{
    public NoConnectionException() {
        super("Błąd połączenia");
    }
}

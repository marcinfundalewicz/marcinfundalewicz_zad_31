package pl.javastart.zadanie31;

public class CityNotFoundException extends RuntimeException{
    public CityNotFoundException() {
        super("Nie znaleziono miasta o podanej nazwie");
    }
}

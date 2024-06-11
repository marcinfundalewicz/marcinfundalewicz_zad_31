package pl.javastart.jjdind84_marcinfundalewicz_zad_31;

public class CityNotFoundException extends RuntimeException{
    public CityNotFoundException() {
        super("Nie znaleziono miasta o podanej nazwie");
    }
}

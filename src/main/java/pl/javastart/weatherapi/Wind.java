package pl.javastart.weatherapi;


import lombok.Data;

@Data
class Wind {
    private double speed;
    private int deg;
    private double gust;
}

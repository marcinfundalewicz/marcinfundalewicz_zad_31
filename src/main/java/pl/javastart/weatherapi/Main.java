package pl.javastart.weatherapi;

import lombok.Data;

@Data
class Main {
    private double temp;
    private int pressure;
    private int humidity;
}

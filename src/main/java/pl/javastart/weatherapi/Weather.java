package pl.javastart.weatherapi;

import lombok.Data;

@Data
class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;

}

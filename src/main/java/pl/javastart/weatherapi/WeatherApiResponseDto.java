package pl.javastart.weatherapi;

import lombok.Data;

import java.util.List;

@Data
class WeatherApiResponseDto {
    private Clouds clouds;
    private Coord coord;
    private Main main;
    private Rain rain;
    private Sys sys;
    private List<Weather> weather;
    private Wind wind;
    private String base;
    private int visibility;
    private long dt;
    private int timezone;
    private long id;
    private String name;
    private int cod;
}

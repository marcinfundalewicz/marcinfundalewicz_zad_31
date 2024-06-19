package pl.javastart.weatherapi;

import lombok.Data;

@Data
class WeatherApiResponseDto {
    private Main main;
    private Wind wind;
    private int visibility;
    private String name;
}

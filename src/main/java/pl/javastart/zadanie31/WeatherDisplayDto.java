package pl.javastart.zadanie31;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WeatherDisplayDto {
    private String cityName;
    private double temp;
    private int humidity;
    private int pressure;
    private int visibility;
    private double windSpeed;

    public WeatherDisplayDto(String cityName, double temp, int humidity, int pressure, int visibility, double windSpeed) {
        this.cityName = cityName;
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.visibility = visibility;
        this.windSpeed = windSpeed;
    }
}

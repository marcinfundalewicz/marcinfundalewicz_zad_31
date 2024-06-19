package pl.javastart.weatherapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.javastart.zadanie31.CityNotFoundException;
import pl.javastart.zadanie31.NoConnectionException;
import pl.javastart.zadanie31.WeatherDisplayDto;

import java.net.UnknownHostException;

@Service
public class WeatherApiService {
    private final String openWeatherApiKey;

    public WeatherApiService(@Value("${app.weatherapi.key}") String openWeatherApiKey) {
        this.openWeatherApiKey = openWeatherApiKey;
    }

    public WeatherDisplayDto getWeatherInCity(String city) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + openWeatherApiKey + "&units=metric";

            WeatherApiResponseDto apiResponse = restTemplate.getForObject(url, WeatherApiResponseDto.class);
            return weatherToDisplayMapper(apiResponse);

        } catch (Exception e) {
            if (e.getCause() instanceof UnknownHostException) {
                throw new NoConnectionException();
            } else {
             throw new CityNotFoundException();
            }
        }
    }

    private WeatherDisplayDto weatherToDisplayMapper(WeatherApiResponseDto weatherApiResponseDto) {
            String cityName = (weatherApiResponseDto.getName());
            int visibility = (weatherApiResponseDto.getVisibility());
            double temperature = weatherApiResponseDto.getMain().getTemp();
            int pressure = (weatherApiResponseDto.getMain().getPressure());
            int humidity = (weatherApiResponseDto.getMain().getHumidity());
            double windSpeed = (weatherApiResponseDto.getWind().getSpeed());
            WeatherDisplayDto weatherDisplayDto = new WeatherDisplayDto(cityName, temperature, humidity, pressure, visibility, windSpeed);
            return weatherDisplayDto;
    }
}
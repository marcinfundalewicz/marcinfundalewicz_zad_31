package pl.javastart.weatherapi;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.javastart.zadanie31.CityNotFoundException;
import pl.javastart.zadanie31.NoConnectionException;
import pl.javastart.zadanie31.WeatherDisplayDto;

@Service
public class WeatherApiService {
    private final String openWeatherApiKey = "407fb443f6946a53f2123b6791efde13";

    public WeatherDisplayDto getWeatherInCity(String city) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + openWeatherApiKey + "&units=metric";

            WeatherApiResponseDto apiResponse = restTemplate.getForObject(url, WeatherApiResponseDto.class);
            return weatherToDisplayMapper(apiResponse);

        } catch (Exception e) {
            if (e instanceof NoConnectionException) {
                throw new NoConnectionException();
            } else {
             throw new CityNotFoundException();
            }
        }
    }

    private WeatherDisplayDto weatherToDisplayMapper(WeatherApiResponseDto weatherApiResponseDto) {
        if (weatherApiResponseDto != null) {
            String cityName = (weatherApiResponseDto.getName());
            int visibility = (weatherApiResponseDto.getVisibility());
            double temperature = weatherApiResponseDto.getMain().getTemp();
            int pressure = (weatherApiResponseDto.getMain().getPressure());
            int humidity = (weatherApiResponseDto.getMain().getHumidity());
            double windSpeed = (weatherApiResponseDto.getWind().getSpeed());
            WeatherDisplayDto weatherDisplayDto = new WeatherDisplayDto(cityName, temperature, humidity, pressure, visibility, windSpeed);
            return weatherDisplayDto;
        } else {
            throw new NoConnectionException();
        }
    }
}
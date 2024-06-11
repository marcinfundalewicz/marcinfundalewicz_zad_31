package pl.javastart.weatherapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.javastart.jjdind84_marcinfundalewicz_zad_31.CityNotFoundException;
import pl.javastart.jjdind84_marcinfundalewicz_zad_31.WeatherDisplayDto;

@Service
public class WeatherApiService {
    private final String openWeatherApiKey = "407fb443f6946a53f2123b6791efde13";

    public WeatherDisplayDto getWeatherInCity(String city) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + openWeatherApiKey;

            WeatherApiResponseDto apiResponse = restTemplate.getForObject(url, WeatherApiResponseDto.class);
            return weatherToDisplayMapper(apiResponse);

        } catch (Exception e) {
            throw new CityNotFoundException();
        }
    }

    private WeatherDisplayDto weatherToDisplayMapper(WeatherApiResponseDto weatherApiResponseDto) {
        return WeatherDisplayDto.builder()
                .cityName(weatherApiResponseDto.getName())
                .visibility(weatherApiResponseDto.getVisibility())
                .temp(weatherApiResponseDto.getMain().getTemp())
                .pressure(weatherApiResponseDto.getMain().getPressure())
                .humidity(weatherApiResponseDto.getMain().getHumidity())
                .windSpeed(weatherApiResponseDto.getWind().getSpeed())
                .build();
    }
}

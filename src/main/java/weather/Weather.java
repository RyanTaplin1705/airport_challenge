package weather;

import java.util.Random;

public class Weather {

    public WeatherType type;

    public Weather(Random randomGenerator) {
        this.type = getWeatherType(randomNumber(randomGenerator));
    }

    public boolean isSafe() {
        return !type.equals(WeatherType.STORMY);
    }

    private WeatherType getWeatherType(int number) {
        if (number < 80) return WeatherType.SUNNY;
        else return WeatherType.STORMY;
    }

    private int randomNumber(Random random) {
        return random.nextInt(100) + 1;
    }
}

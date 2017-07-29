import java.util.Random;

public class Weather {

    public String type;

    public Weather(Random randomGenerator) {
        this.type = getWeatherType(randomNumber(randomGenerator));
    }

    private String getWeatherType(int number) {
        if (number < 80) return "Sunny";
        else return "Stormy";
    }

    private int randomNumber(Random random) {
        return random.nextInt(100) + 1;
    }
}

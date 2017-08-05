import org.junit.Test;
import weather.Weather;
import weather.WeatherType;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class WeatherTest {

    private Random random = mock(Random.class);

    @Test
    public void weatherCanBeSunny() throws Exception {
        givenTheRandomGeneratorWillReturn(0);
        Weather weather = whenWeCreateWeather();
        theWeatherTypeWillBe(weather, WeatherType.SUNNY);
    }

    @Test
    public void weatherCanBeStormy() throws Exception {
        givenTheRandomGeneratorWillReturn(99);
        Weather weather = whenWeCreateWeather();
        theWeatherTypeWillBe(weather, WeatherType.STORMY);
    }

    @Test
    public void weatherIsSafe() throws Exception {
        givenTheRandomGeneratorWillReturn(0);
        Weather weather = whenWeCreateWeather();
        assertThat(weather.isSafe()).isTrue();
    }

    @Test
    public void weatherIsNotSafe() throws Exception {
        givenTheRandomGeneratorWillReturn(99);
        Weather weather = whenWeCreateWeather();
        assertThat(weather.isSafe()).isFalse();
    }

    //givens
    private void givenTheRandomGeneratorWillReturn(int number) {
        given(random.nextInt(100)).willReturn(number);
    }

    //whens
    private Weather whenWeCreateWeather() {
        return new Weather(random);
    }

    //thens
    private void theWeatherTypeWillBe(Weather weather, WeatherType type) {
        assertThat(weather.type).isEqualTo(type);
    }
}
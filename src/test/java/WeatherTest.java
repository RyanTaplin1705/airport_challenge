import org.junit.Test;

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
        theWeatherTypeWillBe(weather, "Sunny");
    }

    @Test
    public void weatherCanBeStormy() throws Exception {
        givenTheRandomGeneratorWillReturn(99);
        Weather weather = whenWeCreateWeather();
        theWeatherTypeWillBe(weather, "Stormy");
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
    private void theWeatherTypeWillBe(Weather weather, String sunny) {
        assertThat(weather.type).isEqualTo(sunny);
    }
}
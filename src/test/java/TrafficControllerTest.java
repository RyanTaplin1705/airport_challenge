import org.junit.Before;
import org.junit.Test;
import weather.Weather;
import weather.WeatherType;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TrafficControllerTest {

    private static final WeatherType OTHER_WEATHER = WeatherType.SUNNY;
    private static final WeatherType STORMY_WEATHER = WeatherType.STORMY;
    private TrafficController trafficController;

    private Plane plane = mock(Plane.class);
    private Airport airport = mock(Airport.class);
    private Weather weather = mock(Weather.class);

    @Before
    public void setUp() throws Exception {
        airport.weather = weather;
        trafficController = new TrafficController(airport);
    }

    @Test
    public void instructPlaneToLandAtAirport() throws Exception {
        givenAirportIsNotFull();
        givenWeatherIsSafe();
        whenTrafficControllerInstructsPlaneToLand();
        thePlaneReceivesTheInstructionToLand();
    }

    private void givenWeatherIsSafe() {
        given(weather.isSafe()).willReturn(true);
    }

    @Test
    public void instructPlaneToDepartFromAirport() throws Exception {
        givenWeatherIsSafe();
        whenTrafficControllerInstructsPlaneToDepart();
        thePlaneReceivesTheInstructionToDepart();
    }

    @Test
    public void cantInstructPlaneToDepartFromAirportIfWeatherIsStormy() throws Exception {
        givenWeatherIsNotSafe();
        whenTrafficControllerInstructsPlaneToDepart();
        thePlaneDoesNotReceiveInstructionToDepart();
    }

    @Test
    public void cantInstructPlaneToLandAtAirportIfWeatherIsStormy() throws Exception {
        givenAirportIsNotFull();
        givenWeatherIsNotSafe();
        whenTrafficControllerInstructsPlaneToLand();
        thePlaneDoesNotReceiveInstructionToLand();
    }

    @Test
    public void cantInstructPlaneToLandAtAirportThatIsFull() throws Exception {
        givenAirportIsFull();
        givenWeatherIsSafe();
        whenTrafficControllerInstructsPlaneToLand();
        thePlaneDoesNotReceiveInstructionToLand();
    }

    @Test
    public void canInstructPlaneToLandWhenAirportIsNotFull() throws Exception {
        givenAirportIsNotFull();
        givenWeatherIsSafe();
        whenTrafficControllerInstructsPlaneToLand();
        thePlaneReceivesTheInstructionToLand();
    }

    private void givenAirportIsFull() {
        given(airport.hasSpaces()).willReturn(false);
    }

    private void givenAirportIsNotFull() {
        given(airport.hasSpaces()).willReturn(true);
    }

    private void givenWeatherIsNotSafe() {
        given(weather.isSafe()).willReturn(false);
    }

    private void whenTrafficControllerInstructsPlaneToDepart() {
        trafficController.instructDepart(plane);
    }

    private void whenTrafficControllerInstructsPlaneToLand() {
        trafficController.instructLand(plane);
    }

    private void thePlaneReceivesTheInstructionToLand() {
        verify(plane).land(airport);
    }

    private void thePlaneDoesNotReceiveInstructionToLand() {
        verify(plane, never()).land(airport);
    }

    private void thePlaneDoesNotReceiveInstructionToDepart() {
        verify(plane, never()).depart();
    }

    private void thePlaneReceivesTheInstructionToDepart() {
        verify(plane).depart();
    }
}
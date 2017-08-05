import org.junit.Before;
import org.junit.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TrafficControllerTest {

    public static final String OTHER_WEATHER = "Sunny";
    public static final String STORMY_WEATHER = "Stormy";
    private TrafficController trafficController;
    private Plane plane = mock(Plane.class);
    private Airport airport = mock(Airport.class);

    @Before
    public void setUp() throws Exception {
        trafficController = new TrafficController(airport);
    }

    @Test
    public void instructPlaneToLandAtAirport() throws Exception {
        givenAirportIsNotFull();
        givenAirportWeatherIsNotStormy();
        whenTrafficControllerInstructsPlaneToLand();
        thePlaneReceivesTheInstructionToLand();
    }

    private void givenAirportWeatherIsNotStormy() {
        given(airport.getWeather()).willReturn(OTHER_WEATHER);
    }

    @Test
    public void instructPlaneToDepartFromAirport() throws Exception {
        givenAirportWeatherIsNotStormy();
        whenTrafficControllerInstructsPlaneToDepart();
        thePlaneReceivesTheInstructionToDepart();
    }

    @Test
    public void cantInstructPlaneToDepartFromAirportIfWeatherIsStormy() throws Exception {
        givenAirportWeatherIsStormy();
        whenTrafficControllerInstructsPlaneToDepart();
        thePlaneDoesNotReceiveInstructionToDepart();
    }

    @Test
    public void cantInstructPlaneToLandAtAirportIfWeatherIsStormy() throws Exception {
        givenAirportIsNotFull();
        givenAirportWeatherIsStormy();
        whenTrafficControllerInstructsPlaneToLand();
        thePlaneDoesNotReceiveInstructionToLand();
    }

    @Test
    public void cantInstructPlaneToLandAtAirportThatIsFull() throws Exception {
        givenAirportIsFull();
        givenAirportWeatherIsNotStormy();
        whenTrafficControllerInstructsPlaneToLand();
        thePlaneDoesNotReceiveInstructionToLand();
    }

    @Test
    public void canInstructPlaneToLandWhenAirportIsNotFull() throws Exception {
        givenAirportIsNotFull();
        givenAirportWeatherIsNotStormy();
        whenTrafficControllerInstructsPlaneToLand();
        thePlaneReceivesTheInstructionToLand();
    }

    private void givenAirportIsFull() {
        given(airport.hasSpaces()).willReturn(false);
    }

    private void givenAirportIsNotFull() {
        given(airport.hasSpaces()).willReturn(true);
    }

    private void givenAirportWeatherIsStormy() {
        given(airport.getWeather()).willReturn(STORMY_WEATHER);
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
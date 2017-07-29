import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TrafficControllerTest {

    private TrafficController trafficController = new TrafficController();
    private Plane plane = mock(Plane.class);
    private Airport airport = mock(Airport.class);

    @Test
    public void instructPlaneToLandAtAirport() throws Exception {
        givenAirportIsNotFull();
        whenTrafficControllerInstructsPlaneToLand();
        thePlaneReceivesTheInstructionToLand();
    }

    @Test
    public void instructPlaneToDepartFromAirport() throws Exception {
        whenTrafficControllerInstructsPlaneToDepart();
        thePlaneReceivesTheInstructionToDepart();
    }

    @Ignore
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
        whenTrafficControllerInstructsPlaneToLand();
        thePlaneDoesNotReceiveInstructionToLand();
    }

    @Test
    public void canInstructPlaneToLandWhenAirportIsNotFull() throws Exception {
        givenAirportIsNotFull();
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
        given(airport.getWeather()).willReturn("Stormy");
    }

    private void whenTrafficControllerInstructsPlaneToDepart() {
        trafficController.instructDepart(plane);
    }

    private void whenTrafficControllerInstructsPlaneToLand() {
        trafficController.instructLand(plane, airport);
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
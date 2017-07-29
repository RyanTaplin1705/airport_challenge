import org.junit.Test;

public class TrafficControllerTest {

    private TrafficController trafficController = new TrafficController();

    @Test
    public void instructPlaneToLandAtAirport() throws Exception {
        givenWeHaveAnAirport();
        givenWeHaveAPlane();

        whenTrafficControllerInstructsPlaneToLand();

        thePlaneConfirmsLanding();
        andAirportAcknowledgesArrivalOfThePlane();
    }

    private void andAirportAcknowledgesArrivalOfThePlane() {

    }

    private void thePlaneConfirmsLanding() {

    }

    private void whenTrafficControllerInstructsPlaneToLand() {

    }

    private void givenWeHaveAPlane() {

    }

    private void givenWeHaveAnAirport() {

    }
}
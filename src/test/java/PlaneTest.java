import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class PlaneTest {

    private Plane plane = new Plane();

    private Airport airport = mock(Airport.class);

    @Test
    public void whenFlyingPlaneIsInstructedToLand() throws Exception {
        givenPlaneIsFlying();
        whenPlaneIsInstructedToLand();
        thenPlaneIsNoLongerFlying();
    }

    @Test
    public void whenStationaryPlaneIsDepart() throws Exception {
        givenPlaneIsAtAirport();
        whenPlaneIsInstructedToDepart();
        thenPlaneIsFlying();
    }

    private void givenPlaneIsAtAirport() {
        plane.isFlying = false;
    }

    private void givenPlaneIsFlying() {
        plane.isFlying = true;
    }

    private void whenPlaneIsInstructedToDepart() {
        plane.depart();
    }

    private void whenPlaneIsInstructedToLand() {
        plane.land(airport);
    }

    private void thenPlaneIsNoLongerFlying() {
        assertThat(plane.isFlying).isFalse();
    }

    private void thenPlaneIsFlying() {
        assertThat(plane.isFlying).isTrue();
    }
}
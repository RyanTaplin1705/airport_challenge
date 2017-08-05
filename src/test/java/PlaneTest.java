import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class PlaneTest {

    private Plane plane = new Plane();

    private Airport airport = mock(Airport.class);
    private Dock dock = mock(Dock.class);

    @Test
    public void whenFlyingPlaneIsInstructedToLand() throws Exception {
        givenPlaneIsFlying();
        givenAirportHasAvailableDock();

        whenPlaneIsInstructedToLand();

        thenPlaneLandsAtAvailableDock();
        andThePlaneIsNoLongerFlying();
    }

    @Test
    public void whenStationaryPlaneIsDepart() throws Exception {
        givenPlaneIsAtAirport();

        whenPlaneIsInstructedToDepart();

        thenThePlaneIsFlying();
    }

    private void givenAirportHasAvailableDock() {
        given(airport.getAvailableDock()).willReturn(dock);
    }

    private void givenPlaneIsAtAirport() {
        plane.docked = dock;
    }

    private void givenPlaneIsFlying() {
        plane.docked = null;
    }

    private void whenPlaneIsInstructedToDepart() {
        plane.depart();
    }

    private void whenPlaneIsInstructedToLand() {
        plane.land(airport);
    }

    private void thenPlaneLandsAtAvailableDock() {
        assertThat(plane.docked).isEqualTo(dock);
    }

    private void andThePlaneIsNoLongerFlying() {
        assertThat(plane.docked).isNotEqualTo(null);
    }

    private void thenThePlaneIsFlying() {
        assertThat(plane.docked).isEqualTo(null);
    }
}
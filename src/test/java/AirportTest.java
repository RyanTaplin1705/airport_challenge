import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class AirportTest {
    private Airport airport = new Airport();
    private Plane plane = mock(Plane.class);
    private Dock dock = mock(Dock.class);

    @Test
    public void confirmPlaneIsNotDocked() throws Exception {
        givenPlaneIsNotDockedAtAirport();
        boolean docked = airport.isDocked(plane);
        assertThat(docked).isFalse();
    }

    @Test
    public void confirmPlaneIsDocked() throws Exception {
        givenPlaneIsDockedAtAirport();
        boolean docked = airport.isDocked(plane);
        assertThat(docked).isTrue();
    }

    private void givenPlaneIsNotDockedAtAirport() {
        given(dock.hasPlane(plane)).willReturn(false);
        airport.docks = new Dock[]{dock};
    }

    private void givenPlaneIsDockedAtAirport() {
        given(dock.hasPlane(plane)).willReturn(true);
        airport.docks = new Dock[]{dock};
    }
}
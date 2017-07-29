import org.junit.Before;
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

    private void givenPlaneIsFlying() {
        plane.isFlying = true;
    }

    private void whenPlaneIsInstructedToLand() {
        plane.land(airport);
    }

    private void thenPlaneIsNoLongerFlying() {
        assertThat(plane.isFlying).isFalse();
    }
}
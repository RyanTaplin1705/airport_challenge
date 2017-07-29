import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class DockTest {

    private Dock dock = new Dock();
    private Plane plane = mock(Plane.class);

    @Test
    public void verifyPlaneIsDocked() throws Exception {
        givenPlaneIsDocked();
        assertThat(dock.hasPlane(plane)).isTrue();
    }

    @Test
    public void verifyPlaneIsNotDocked() throws Exception {
        assertThat(dock.hasPlane(plane)).isFalse();
    }

    @Test
    public void verifyDockIsVacantWhenPlaneIsDocked() throws Exception {
        assertThat(dock.isVacant()).isTrue();
    }

    @Test
    public void verifyDockIsOccupiedWhenPlaneIsDocked() throws Exception {
        givenPlaneIsDocked();
        assertThat(dock.isVacant()).isFalse();
    }

    private void givenPlaneIsDocked() {
        dock.plane = plane;
    }
}
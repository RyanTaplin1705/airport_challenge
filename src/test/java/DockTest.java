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

    private void givenPlaneIsDocked() {
        dock.plane = plane;
    }
}
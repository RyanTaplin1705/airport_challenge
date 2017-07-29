import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class AirportTest {
    private Airport airport = new Airport();

    private Plane plane = mock(Plane.class);
    private Dock occupiedDock = mock(Dock.class);
    private Dock vacantDock = mock(Dock.class);


    @Before
    public void setUp() throws Exception {
        given(vacantDock.isVacant()).willReturn(true);
        given(occupiedDock.isVacant()).willReturn(false);
    }

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

    @Test
    public void confirmAirportHasAvailableDock() throws Exception {
        givenAirportDockIsVacant();
        boolean hasSpaces = airport.hasSpaces();
        assertThat(hasSpaces).isTrue();
    }

    @Test
    public void confirmAirportHasNoAvailableDock() throws Exception {
        givenAirportDockIsOccupied();
        boolean hasSpaces = airport.hasSpaces();
        assertThat(hasSpaces).isFalse();
    }

    @Test
    public void confirmAirportCanFindAvailableDockWhenMultiple() throws Exception {
        givenAirportHasMultipleDocksAndOneIsVacant();
        boolean hasSpaces = airport.hasSpaces();
        assertThat(hasSpaces).isTrue();
    }

    private void givenAirportHasMultipleDocksAndOneIsVacant() {
        airport.docks = new Dock[]{occupiedDock, occupiedDock, occupiedDock, vacantDock, occupiedDock};
    }

    private void givenAirportDockIsOccupied() {
        airport.docks = new Dock[]{occupiedDock};
    }

    private void givenAirportDockIsVacant() {
        airport.docks = new Dock[]{vacantDock};
    }

    private void givenPlaneIsNotDockedAtAirport() {
        given(occupiedDock.hasPlane(plane)).willReturn(false);
        airport.docks = new Dock[]{occupiedDock};
    }

    private void givenPlaneIsDockedAtAirport() {
        given(occupiedDock.hasPlane(plane)).willReturn(true);
        airport.docks = new Dock[]{occupiedDock};
    }
}
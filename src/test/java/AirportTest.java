import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class AirportTest {

    private static final int CUSTOM_CAPACITY = 999;
    private static final int DEFAULT_CAPACITY = 10;
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

    @Test
    public void airportDefaultCapacityIsTen() throws Exception {
        assertThat(airport.maximumCapacity()).isEqualTo(DEFAULT_CAPACITY);
    }

    @Test
    public void airportCanHaveCustomCapacity() throws Exception {
        Airport customAirport = new Airport(CUSTOM_CAPACITY);
        assertThat(customAirport.maximumCapacity()).isEqualTo(CUSTOM_CAPACITY);
    }

    @Test
    public void airportReturnsDockWhenAvailableIsFound() {
        givenAirportHasMultipleDocksAndOneIsVacant();
        assertThat(airport.getAvailableDock()).isEqualTo(vacantDock);
    }

    @Test
    public void airportReturnsInvalidValueWhenNoAvailableDockIsFound() {
        givenAirportDockIsOccupied();
        assertThat(airport.getAvailableDock()).isEqualTo(null);
    }

    private void givenAirportHasMultipleDocksAndOneIsVacant() {
        airport.docks = asList(occupiedDock, occupiedDock, occupiedDock, vacantDock, occupiedDock);
    }

    private void givenAirportDockIsOccupied() {
        airport.docks = singletonList(occupiedDock);
    }

    private void givenAirportDockIsVacant() {
        airport.docks = singletonList(vacantDock);
    }

    private void givenPlaneIsNotDockedAtAirport() {
        given(occupiedDock.hasPlane(plane)).willReturn(false);
        airport.docks = singletonList(occupiedDock);
    }

    private void givenPlaneIsDockedAtAirport() {
        given(occupiedDock.hasPlane(plane)).willReturn(true);
        airport.docks = singletonList(occupiedDock);
    }
}
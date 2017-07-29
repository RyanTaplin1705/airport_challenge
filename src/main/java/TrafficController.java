public class TrafficController {

    public void instructLand(Plane plane, Airport airport) {
        if (airport.hasSpaces()) {
            plane.land(airport);
        }
    }

    public void instructDepart(Plane plane) {
        plane.depart();
    }
}

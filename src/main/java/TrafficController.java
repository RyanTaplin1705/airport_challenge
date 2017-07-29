public class TrafficController {

    public void instructLand(Plane plane, Airport airport) {
        plane.land(airport);
    }

    public void instructDepart(Plane plane) {
        plane.depart();
    }
}

public class TrafficController {


    private Airport airport;

    public TrafficController(Airport airport) {
        this.airport = airport;
    }

    public void instructLand(Plane plane) {
        if (airport.hasSpaces() && airport.weather.isSafe()){
            plane.land(airport);
        }
    }

    public void instructDepart(Plane plane) {
        if (airport.weather.isSafe()) {
            plane.depart();
        }
    }
}

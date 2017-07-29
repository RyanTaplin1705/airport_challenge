public class TrafficController {

    public void instructLand(Plane plane, Airport airport) {
        if (airport.hasSpaces() && isNotStormy(airport.getWeather())) {
            plane.land(airport);
        }
    }

    private boolean isNotStormy(String weather) {
        return !weather.equals("Stormy");
    }

    public void instructDepart(Plane plane) {
        plane.depart();
    }
}

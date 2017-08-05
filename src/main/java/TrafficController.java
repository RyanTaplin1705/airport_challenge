public class TrafficController {


    private Airport airport;

    public TrafficController(Airport airport) {
        this.airport = airport;
    }

    public void instructLand(Plane plane) {
        if (airport.hasSpaces() && isNotStormy(airport.getWeather())) {
            plane.land(airport);
        }
    }

    private boolean isNotStormy(String weather) {
        return !weather.equals("Stormy");
    }

    public void instructDepart(Plane plane) {
        if (isNotStormy(airport.getWeather())) {
            plane.depart();
        }
    }
}

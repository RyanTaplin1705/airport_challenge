public class Plane {

    public Dock docked;

    public void land(Airport airport) {
        docked = airport.getAvailableDock();
        docked.plane = this;
    }

    public void depart() {
        docked.plane = null;
        docked = null;
    }
}

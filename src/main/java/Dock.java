public class Dock {

    public Plane plane;

    public boolean hasPlane(Plane plane) {
        if (this.plane != null && this.plane.equals(plane)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isVacant() {
        return false;
    }
}

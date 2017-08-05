public class Dock {

    public Plane plane;

    public boolean hasPlane(Plane plane) {
        return this.plane != null && this.plane.equals(plane);
    }

    public boolean isVacant() {
        return plane == null;
    }
}

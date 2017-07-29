public class Airport {


    public Dock[] docks;

    public boolean isDocked(Plane plane) {
        for (Dock dock : docks) {
            if (dock.hasPlane(plane)) return true;
        }
        return false;
    }

    public boolean hasSpaces() {
        for (Dock dock : docks) {
            if (dock.isVacant()) return true;
        }
        return false;
    }
}

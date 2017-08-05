import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Airport {

    private static final int DEFAULT_CAPACITY = 10;

    private Weather weather = new Weather(new Random());
    public List<Dock> docks;

    public Airport(int capacity) {
        docks = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            docks.add(new Dock());
        }
    }

    public Airport() {
        docks = new ArrayList<>();
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            docks.add(new Dock());
        }
    }

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

    public Dock getAvailableDock() {
        for (Dock dock : docks) {
            if (dock.isVacant()) return dock;
        }
        return null;
    }

    public int maximumCapacity() {
        return docks.size();
    }

    public String getWeather() {
        return weather.type;
    }
}

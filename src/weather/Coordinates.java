package weather;

import simulation.exceptions.NegativeCoordinatesException;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height) throws NegativeCoordinatesException {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
        throw new NegativeCoordinatesException(
            String.format("Coordinates can't be negative: lng=%d, lat=%d, height=%d", 
                longitude,latitude, height
        ));
    }
    public int getLongitude() {
        return this.longitude;
    }
    public int getLatitude() {
        return this.latitude;
    }
    public int getHeight() {
        return this.height;
    }
}

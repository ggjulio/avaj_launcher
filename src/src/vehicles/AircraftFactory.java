package vehicles;

import weather.Coordinates;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude,
            int height) throws Exception {
        Coordinates Coordinates = new Coordinates(longitude, latitude, height);
        if (type == "Baloon")
            return new Balloon(name, Coordinates);
        if (type == "JetPlane")
            return new JetPlane(name, Coordinates);
        if (type == "Helicopter")
            return new Helicopter(name, Coordinates);
        throw new Exception("Unknown type: %s".formatted(type));
    }
}

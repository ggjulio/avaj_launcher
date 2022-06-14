package vehicles;

import simulation.exceptions.UnknownObserverNameException;
import weather.Coordinates;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude,
            int height) throws Exception {
        Coordinates Coordinates = new Coordinates(longitude, latitude, height);
        if (type.equals("Baloon"))
            return new Baloon(name, Coordinates);
        if (type.equals("JetPlane"))
            return new JetPlane(name, Coordinates);
        if (type.equals("Helicopter"))
            return new Helicopter(name, Coordinates);
        throw new UnknownObserverNameException(String.format("Unknown type: %s", type));
    }
}

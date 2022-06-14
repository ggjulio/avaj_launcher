package vehicles;

import simulation.Logger;
import weather.Coordinates;
import weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    protected Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        int longitude = 0, latitude = 0, height = 0;
        String message = "";
        switch (this.weatherTower.getWeather(coordinates)) {
            case "SUN":
                longitude = 10;
                height = 2;
                message = "This is hot.";
                break;
            case "RAIN":
                longitude = 5;
                message = "Rain is great, it clean the helicopter";
                break;
            case "FOG":
                longitude = 1;
                message = "Gonna be hard to land, watch out instruments";
                break;
            case "SNOW":
                height = -12;
                message = " My rotor is going to freeze!";
                break;
        }
        this.coordinates = new Coordinates(
                coordinates.getLongitude() + longitude,
                coordinates.getLatitude() + latitude,
                coordinates.getHeight() + height);
        Logger.getInstance().log(
            String.format("%s#%s(%d):%s",
                this.getClass().getSimpleName(),
                this.name,
                this.id,
                message
        ));
        height = height > 100 ? 100 : height;
        if (height <= 0) {
            Logger.getInstance().log(
                String.format("%s#%s(%d) landing.",
                        this.getClass().getSimpleName(),
                        this.name,
                        this.id));
            this.weatherTower.unregister(this);
            Logger.getInstance().log(
                String.format("Tower says: %s#%s(%d) unregistered to weather tower.",
                    this.getClass().getSimpleName(),
                    this.name,
                    this.id));
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Logger.getInstance().log(
                String.format("Tower says: %s#%s(%d): %s",
                        this.getClass().getSimpleName(),
                        this.name,
                        this.id,
                        "registered to weather tower"));
    }

}

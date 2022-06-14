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
        switch (this.weatherTower.getWeather(coordinates)) {
            case "SUN":
                longitude = 10;
                height = 2;
                break;
            case "RAIN":
                longitude = 5;
                break;
            case "FOG":
                longitude = 1;
                break;
            case "SNOW":
                height = -12;
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
                "A random phrase based on weather"
        ));
        if (height <= 0) {
            this.weatherTower.unregister(this);
            Logger.getInstance().log(
                    String.format("Tower says: %s#%s(%d): %s",
                            this.getClass().getSimpleName(),
                            this.name,
                            this.id,
                            "unregistered to weather tower."));
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        Logger.getInstance().log(
                String.format("Tower says: %s#%s(%d): %s",
                        this.getClass().getSimpleName(),
                        this.name,
                        this.id,
                        "registered to weather tower"));
    }

}

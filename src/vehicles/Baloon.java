package vehicles;

import simulation.Logger;
import weather.Coordinates;
import weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        int longitude = 0, latitude = 0, height = 0;
        String message = "";
        switch (this.weatherTower.getWeather(coordinates)) {
            case "SUN":
                longitude = 2;
                height = 4;
                message = "Let's enjoy the good weather and take some pics.";
                break;
            case "RAIN":
                height = -5;
                message = "Damn you rain! You messed up my baloon.";
                break;
            case "FOG":
                height = -3;
                message = "It's fucked up, we can't even see the floor !";
                break;
            case "SNOW":
                height = -15;
                message = "It's snowing. We're gonna crash.";
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
                        "registered to weather tower."));
    }
}

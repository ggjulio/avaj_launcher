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
        switch (this.weatherTower.getWeather(coordinates)) {
            case "SUN":
                longitude = 2;
                height = 4;
            break;
            case "RAIN":
                height = -5;
            break;
            case "FOG":
                height = -3;
            break;
            case "SNOW":
                height = -15;
            break;
        }
        this.coordinates = new Coordinates(
            coordinates.getLongitude() + longitude,
            coordinates.getLatitude() + latitude,
            coordinates.getHeight() + height
        );
        if (height <= 0)
        {
            Logger.getInstance().log(
                String.format("Tower says: %s#%s(%d): %s",
                  this.getClass().getSimpleName(),
                  this.name,
                  this.id,
                  "unregistered to weather tower.")
            );
            return;
        }
        Logger.getInstance().log(
          String.format("%s#%s(%d):%s",
            this.getClass().getSimpleName(),
            this.name,
            this.id,
            "A random phrase based on weather")
        );
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        Logger.getInstance().log(
            String.format("Tower says: %s#%s(%d): %s",
              this.getClass().getSimpleName(),
              this.name,
              this.id,
              "registered to weather tower.")
        );
    }
}

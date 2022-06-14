package vehicles;

import simulation.Logger;
import weather.Coordinates;
import weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    protected JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        int longitude = 0, latitude = 0, height = 0;
        switch (this.weatherTower.getWeather(coordinates)) {
            case "SUN":
                latitude = 10;
                height = 2;
            break;
            case "RAIN":
                latitude = 5;
            break;
            case "FOG":
                latitude = 1;
            break;
            case "SNOW":
                height = -7;
            break;
        }
        this.coordinates = new Coordinates(
            coordinates.getLongitude() + longitude,
            coordinates.getLatitude() + latitude,
            coordinates.getHeight() + height
        );
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
              "registered to weather tower")
        );
    }

}

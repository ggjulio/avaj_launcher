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
        String message = "";
        switch (this.weatherTower.getWeather(coordinates)) {
            case "SUN":
                latitude = 10;
                height = 2;
                message = "We're going to have sunburns";
            break;
            case "RAIN":
                latitude = 5;
                message = " It's raining. Better watch out for lightings.";
            break;
            case "FOG":
                latitude = 1;
                message = "I don't see nothing...hard landing incoming !";
            break;
            case "SNOW":
                height = -7;
                message = "OMG! Winter is coming!";
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
            message)
        );
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
              "registered to weather tower")
        );
    }

}

package vehicles;

import weather.Coordinates;
import weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    protected Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        weatherTower = new WeatherTower();
    }

    @Override
    public void updateConditions() {
        // TODO Auto-generated method stub

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        // TODO Auto-generated method stub

    }

}

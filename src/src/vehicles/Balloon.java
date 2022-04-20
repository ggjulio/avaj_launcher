package vehicles;
import Aircraft;
import Coordinates;
import Flyable;
import WeatherTower;

public class Balloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public Balloon(String name, Coordinates coordinates) {
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

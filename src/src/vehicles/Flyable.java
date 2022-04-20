import WeatherTower;package vehicles;


public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}

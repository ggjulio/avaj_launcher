package weather;

public class WeatherProvider {
	private static WeatherProvider INSTANCE;
	private static String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

	private WeatherProvider() {
	}

	public WeatherProvider getProvider() {
		if (INSTANCE == null)
			INSTANCE = new WeatherProvider();
		return INSTANCE;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		var idx = coordinates.getLatitude() + coordinates.getLongitude() + coordinates.getHeight();
		return weather[idx % weather.length];
	}
}

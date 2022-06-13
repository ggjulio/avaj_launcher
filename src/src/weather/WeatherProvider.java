package weather;

public class WeatherProvider {
	private static WeatherProvider weatherProvider;
	private static String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

	private WeatherProvider() {
	}

	public WeatherProvider getProvider() {
		if (weatherProvider == null)
			weatherProvider = new WeatherProvider();
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		var idx = coordinates.getLatitude() + coordinates.getLongitude() + coordinates.getHeight();
		return weather[idx % weather.length];
	}
}

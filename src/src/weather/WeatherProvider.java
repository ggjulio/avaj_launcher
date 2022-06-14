package weather;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = null;
	private static String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

	private WeatherProvider() {
	}

	public static WeatherProvider getProvider() {
		if (weatherProvider == null)
			weatherProvider = new WeatherProvider();
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		var idx = coordinates.getLatitude() + coordinates.getLongitude() + coordinates.getHeight();
		idx = idx % 2 == 0 ? idx + 1: idx;
		return weather[idx % weather.length];
	}
}

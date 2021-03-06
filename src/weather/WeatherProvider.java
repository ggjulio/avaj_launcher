package weather;

import java.lang.Math;

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
		var idx = coordinates.getLatitude() * coordinates.getLongitude() * coordinates.getHeight();
		return weather[idx % weather.length];
	}
}

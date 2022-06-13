package simulation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import vehicles.AircraftFactory;
import vehicles.Flyable;
import weather.WeatherTower;

public class App {

	private static WeatherTower weatherTower;
	private static List<Flyable> flyables = new ArrayList<Flyable>();

	public static void main(String[] args) throws Exception {
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String line = br.readLine();

			if (line != null) {
				weatherTower = new WeatherTower();
				int nbSimulations = Integer.parseInt(line);

				if (nbSimulations <= 0) {
					System.err.println("Invalid simulations count %d".formatted(nbSimulations));
					System.exit(1);
				}
				while ((line = br.readLine()) != null) {
					var arr = line.split(" ");
					Flyable flyable = AircraftFactory.newAircraft(
							arr[0], arr[1],
							Integer.parseInt(arr[2]),
							Integer.parseInt(arr[3]),
							Integer.parseInt(arr[4]));
					flyables.add(flyable);
				}
				for (Flyable flyable : flyables)
					flyable.registerTower(weatherTower);
				for (int i = 0; i < nbSimulations; i++)
					weatherTower.changeWeather();
			}
			br.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}

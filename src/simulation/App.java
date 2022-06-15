package simulation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import simulation.exceptions.InvalidSimulationCountException;
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

				if (nbSimulations <= 0)
					throw new InvalidSimulationCountException(String.format("Invalid simulations count %d", nbSimulations));
				int idxLine = 0;
				while ((line = br.readLine()) != null) {
					var arr = line.split(" ");
					if ( arr.length != 5 )
						throw new Exception(
							String.format("Too %s arguments provided at line %d.\n"
										+"The format is: TYPE NAME LONGITUDE LATITUDE HEIGHT",
										(arr.length < 5 ? "few" : "much"), idxLine));
					if (Integer.parseInt(arr[2]) < 0 || Integer.parseInt(arr[3]) < 0 || Integer.parseInt(arr[4]) < 0)
						throw new Exception(String.format("Negative coordinate a line %d. Please put fix it!", idxLine));
					
					Flyable flyable = AircraftFactory.newAircraft(
							arr[0], arr[1],
							Integer.parseInt(arr[2]),
							Integer.parseInt(arr[3]),
							Integer.parseInt(arr[4]));
					flyables.add(flyable);
					++idxLine;

				}
				for (Flyable flyable : flyables)
					flyable.registerTower(weatherTower);
				for (int i = 0; i < nbSimulations; i++)
					weatherTower.changeWeather();
			}
			br.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.toString());
		}
	}
}

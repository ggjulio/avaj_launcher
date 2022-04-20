import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

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
                while (line != null) {
                    var arr = line.split(" ");
                    Flyable flyable = AircraftFactory.newAircraft(
                            arr[0], arr[1],
                            Integer.parseInt(arr[2]),
                            Integer.parseInt(arr[3]),
                            Integer.parseInt(arr[4]));
                    
                    
                }
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}

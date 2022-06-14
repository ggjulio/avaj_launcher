package simulation;

import java.io.PrintWriter;

public class Logger {
	private static Logger INSTANCE = null;
	private PrintWriter writer;
	
	private Logger(){
		this.writer = new PrintWriter(System.out, true);
	}

	public static Logger getInstance(){
		if (INSTANCE == null)
			INSTANCE = new Logger();
		return INSTANCE;
	}

	public void log(String message) {
		writer.println(message);
	}

	public void logAircraft(String type, String name, String id, String message) {
		writer.println(
			String.format("%s#%s(%d):", type, name, id, message)  
		);
	}
	public void logTower(String type, String name, String id, String message) {
		writer.println(
			String.format("Tower says: %s#%s(%d): %s",
				type, name, id, message
		));
	}
}
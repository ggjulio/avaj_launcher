package simulation;

public class Logger {
	private static Logger INSTANCE;

	private Logger(){
		
	}

	public Logger getInstance(){
		if (INSTANCE == null)
			INSTANCE = new Logger();
		return INSTANCE;
	}

}
package weather;

import java.util.List;
import vehicles.Flyable;

public class Tower {
	private List<Flyable> observers;

	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionChanged() {

	}
}

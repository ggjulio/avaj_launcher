package weather;

import java.util.ArrayList;
import java.util.List;
import vehicles.Flyable;

public abstract class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionChanged() {
		List<Flyable> tmp = new ArrayList<Flyable>(this.observers);
		for (Flyable o : tmp)
			o.updateConditions();
	}
}

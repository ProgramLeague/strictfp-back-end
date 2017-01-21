package db.obj;

import java.util.HashMap;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class WriterType {
	public HashMap<String, Boolean> powerMap = new HashMap<>();

	public WriterType(HashMap<String, Boolean> powerMap) {
		this.powerMap = powerMap;
	}

	public HashMap<String, Boolean> getPowerMap() {
		return powerMap;
	}

	public boolean isAllow(String power) {
		if (!powerMap.containsKey(power)) addPower(power);
		return powerMap.get(power);
	}

	public boolean isRefuse(String power) {
		return !isAllow(power);
	}

	public boolean addAllow(String power) {
		return powerMap.put(power, true);
	}

	public boolean addRefuse(String power) {
		return powerMap.put(power, false);
	}

	public boolean addPower(String power) {
		return addRefuse(power);
	}
}

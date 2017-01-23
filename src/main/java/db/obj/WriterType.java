package db.obj;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class WriterType {
	static {
		Map<String, Boolean> normalPower = new HashMap<>();
		normalPower.put("PUBLISH_ARTICLE", true);
		normalPower.put("NON_EXAMINATION_PUBLISH_ARTICLE", false);
		NORMAL_WRITER = new WriterType(normalPower);
		normalPower.put("NON_EXAMINATION_PUBLISH_ARTICLE", true);
		ADVANCED_WRITER = new WriterType(normalPower);
	}

	public static final WriterType NORMAL_WRITER;
	public static final WriterType ADVANCED_WRITER;

	@NotNull
	@Contract(pure = true)
	public static WriterType fromInt(int input) {
		if (input == 0) return NORMAL_WRITER;
		if (input == 1) return ADVANCED_WRITER;
		return NORMAL_WRITER;
	}

	@NotNull
	public final Map<String, Boolean> powerMap;

	/**
	 * default value is 0.
	 * represent the corresponding number in the SQL database.
	 */
	public int powerLevel;

	public WriterType(@NotNull Map<String, Boolean> powerMap) {
		this(powerMap, 0);
	}

	public WriterType(@NotNull Map<String, Boolean> powerMap, int powerLevel) {
		this.powerMap = powerMap;
		this.powerLevel = powerLevel;
	}

	@NotNull
	public Map<String, Boolean> getPowerMap() {
		return powerMap;
	}

	public boolean isAllow(@NotNull @NonNls String power) {
		if (!powerMap.containsKey(power)) addPower(power);
		return powerMap.get(power);
	}

	public boolean isRefuse(@NotNull @NonNls String power) {
		return !isAllow(power);
	}

	public boolean addAllow(@NotNull @NonNls String power) {
		return powerMap.put(power, true);
	}

	public boolean addRefuse(@NotNull @NonNls String power) {
		return powerMap.put(power, false);
	}

	public boolean addPower(@NotNull @NonNls String power) {
		return addRefuse(power);
	}

	@NotNull
	@NonNls
	@Override
	public String toString() {
		return Integer.toString(powerLevel);
	}
}

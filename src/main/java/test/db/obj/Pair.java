package test.db.obj;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Eldath on 2017/1/17 0017.
 *
 * @author Eldath
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Pair {
	@NotNull
	@NonNls
	private final String key, value;

	public Pair(
			@NotNull @NonNls String key,
			@NotNull @NonNls String value) {
		this.key = key;
		this.value = value;
	}

	@Contract(pure = true)
	@NotNull
	public String getKey() {
		return key;
	}

	@Contract(pure = true)
	@NotNull
	public String getValue() {
		return value;
	}

	@Contract(pure = true)
	@NotNull
	public String getCombined() {
		return String.format("%s %s", key, value);
	}

	@Contract(pure = true)
	@NotNull
	@NonNls
	public static String[] convert(Pair[] origin) {
		String[] ret = new String[origin.length];
		for (int i = 0; i < ret.length; ++i) ret[i] = origin[i].getCombined();
		return ret;
	}
}

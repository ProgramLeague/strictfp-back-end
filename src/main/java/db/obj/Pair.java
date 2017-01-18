package db.obj;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Eldath on 2017/1/17 0017.
 *
 * @author Eldath
 */
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
}

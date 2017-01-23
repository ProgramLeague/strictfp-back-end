package db.obj;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Eldath on 2017/1/18 0018.
 *
 * @author Eldath
 */
@SuppressWarnings("WeakerAccess")
public class Tag {
	@NotNull
	@NonNls
	private String name;

	public Tag(@NotNull @NonNls String name) {
		this.name = name;
	}

	@NotNull
	@Contract(value = " -> !null", pure = true)
	public String getName() {
		return name;
	}

	@NotNull
	@NonNls
	@Override
	public String toString() {
		return getName();
	}
}

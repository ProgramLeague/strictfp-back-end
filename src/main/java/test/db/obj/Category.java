package test.db.obj;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Eldath on 2017/1/19 0019.
 *
 * @author Eldath
 */
@SuppressWarnings("WeakerAccess")
public class Category {
	@NotNull
	@NonNls
	private String name;

	public Category(@NotNull @NonNls String name) {
		this.name = name;
	}

	@NotNull
	@NonNls
	@Contract(pure = true)
	public String getName() {
		return name;
	}
}

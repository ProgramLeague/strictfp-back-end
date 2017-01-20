package db.obj;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Eldath on 2017/1/19 0019.
 *
 * @author Eldath
 */

@SuppressWarnings("WeakerAccess")
public class Genders {
	static {
		MALE = new Gender("MALE", 1);
		FEMALE = new Gender("FEMALE", -1);
		SECRET = new Gender("SECRET", 0);
	}

	@NotNull
	public static final Gender MALE;
	@NotNull
	public static final Gender FEMALE;
	@NotNull
	public static final Gender SECRET;

	@Contract(pure = true)
	@NotNull
	public static Gender parseInt(int input) {
		if (input == 1) return MALE;
		else if (input == -1) return FEMALE;
		return SECRET;
	}
}

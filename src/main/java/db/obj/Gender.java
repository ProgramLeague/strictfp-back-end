package db.obj;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("WeakerAccess")
public class Gender {
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
	public static Gender fromInt(int input) {
		if (input == 1) return MALE;
		else if (input == -1) return FEMALE;
		return SECRET;
	}

	private int number;
	@NotNull
	@NonNls
	private String representation;

	public Gender(@NotNull @Nls String representation, int gender) {
		this.representation = representation;
		number = gender;
	}

	@Contract(pure = true)
	public int getNumber() {
		return number;
	}

	@NonNls
	@NotNull
	public String getRepresentation() {
		return representation;
	}
}

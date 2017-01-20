package db.obj;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("WeakerAccess")
public class Gender {
	private int Int;
	@NotNull
	@NonNls
	private String Eng;

	public Gender(@NotNull @NonNls String eng, int gender) {
		Eng = eng;
		Int = gender;
	}

	@Contract(pure = true)
	public int getInt() {
		return Int;
	}

	@NonNls
	@NotNull
	public String getEng() {
		return Eng;
	}
}

package db.obj;

/**
 * Created by Eldath on 2017/1/19 0019.
 *
 * @author Eldath
 */

public class Genders {
	public static final Gender MALE = new Gender("MALE", 1);
	public static final Gender FEMALE = new Gender("FEMALE", -1);
	public static final Gender SECRECY = new Gender("SECRECY", 0);

	public static Gender parseInt(int input) {
		if (input == 1) return MALE;
		else if (input == -1) return FEMALE;
		return SECRECY;
	}
}

package db.obj;

/**
 * Created by Eldath on 2017/1/23 0023.
 *
 * @author Eldath
 */
public class QuizType {
	private int Int;

	static {
		SINGLE_SELECTION = new QuizType(0);
		MULTI_SELECTION = new QuizType(1);
	}

	public static final QuizType SINGLE_SELECTION;
	public static final QuizType MULTI_SELECTION;

	public static QuizType formInt(int input) {
		if (input == 0) return SINGLE_SELECTION;
		if (input == 1) return MULTI_SELECTION;
		return SINGLE_SELECTION;
	}

	public QuizType(int anInt) {
		Int = anInt;
	}

	public int getInt() {
		return Int;
	}
}

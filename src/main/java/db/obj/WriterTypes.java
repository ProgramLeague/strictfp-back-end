package db.obj;

import java.util.HashMap;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class WriterTypes {
	static {
		HashMap<String, Boolean> normalPower = new HashMap<>();
		normalPower.put("PUBLISH_ARTICLE", true);
		normalPower.put("NON_EXAMINATION_PUBLISH_ARTICLE", false);
		_NORMAL_WRITER = new WriterType(normalPower);
		normalPower.put("NON_EXAMINATION_PUBLISH_ARTICLE", true);
		_ADVANCED_WRITER = new WriterType(normalPower);
	}

	public static final WriterType _NORMAL_WRITER;
	public static final WriterType _ADVANCED_WRITER;

	public static WriterType formInt(int input) {
		if (input == 0) return _NORMAL_WRITER;
		if (input == 1) return _ADVANCED_WRITER;
		return _NORMAL_WRITER;
	}
}

package tool;

import org.json.JSONObject;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class Constant {
	@SuppressWarnings("WeakerAccess")
	public static final class JSON {
		static {
			EMPTY_OBJECT = new JSONObject();
			//TODO: add string _ as PADDING. - Akari
			// frog? I don't understand what does 'PADDING' mean.
			// +1s
			//啊呀，PADDING就是那个占位符_啊。。这个东西听说大有用途。 - Akari
			// advice accepted - Eldath
		}

		public static final JSONObject EMPTY_OBJECT;
	}

	static {
		PADDING = "_";
		DATABASE_HOST = "localhost";
		PATH_TO_BLOCK_LIST = "res\\block_list.txt";
	}

	public static final String PADDING;
	public static final String DATABASE_HOST;
	public static final String PATH_TO_BLOCK_LIST;
}

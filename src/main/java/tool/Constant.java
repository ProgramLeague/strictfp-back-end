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
		}

		public static final JSONObject EMPTY_OBJECT;
	}

	public static final class SERVER {
		static {
			DATABASE_HOST = "localhost";
			DATABASE_NAME = "jpXlFuhuWzzFfHThrYsD";
		}

		public static final int SERVER_PORT = 8888; //DEVELOPING USE, WHEN PUBLISH, CHANGE IT TO 80. - Akari

		public static final String DATABASE_NAME;
		public static final String DATABASE_HOST;
	}

	static {
		PADDING = "_";
		PATH_TO_BLOCK_LIST = "res\\block_list.txt";
	}

	public static final String PADDING;
	public static final String PATH_TO_BLOCK_LIST;
}

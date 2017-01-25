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
			SERVER_PORT = Integer.parseInt(Configurations.getSharedInstance().query("SERVER_PORT"));
			DATABASE_HOST = Configurations.getSharedInstance().query("DATABASE_HOST");
			DATABASE_NAME = Configurations.getSharedInstance().query("DATABASE_NAME");
			DATABASE_PORT = Configurations.getSharedInstance().query("DATABASE_PORT");
			DATABASE_PASSWORD = Configurations.getSharedInstance().query("DATABASE_PASSWORD");
			DATABASE_USERNAME = Configurations.getSharedInstance().query("DATABASE_USERNAME");
		}

		public static final int SERVER_PORT;
		public static final String DATABASE_NAME;
		public static final String DATABASE_HOST;
		public static final String DATABASE_PORT;
		public static final String DATABASE_PASSWORD;
		public static final String DATABASE_USERNAME;
	}

	static {
		PADDING = "_";
		PATH_TO_BLOCK_LIST = "res/block_list.txt";
	}

	public static final String PADDING;
	public static final String PATH_TO_BLOCK_LIST;
}

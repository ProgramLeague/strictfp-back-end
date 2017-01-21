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
		}

		public static final JSONObject EMPTY_OBJECT;
	}
}

package test.extern;

import test.db.obj.Pair;
import org.jetbrains.annotations.TestOnly;
import org.json.JSONObject;
import org.junit.Test;

/**
 * Created by ice1000 on 2017/1/21.
 *
 * @author ice1000
 */
public class JsonTest {
	@Test
	@TestOnly
	public void testJson() {
		JSONObject object = new JSONObject();
		object.put("look", "quite");
		object.put("age", 16);
		object.put("haveDick", true);
		object.put("boyNextDoor", new Pair("233", "666"));
		object.put("assWeCan", new JSONObject());
		System.out.println(object.toString());
	}
}

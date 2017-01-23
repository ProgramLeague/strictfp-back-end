package dotest.obj;

import db.obj.Tag;
import org.jetbrains.annotations.TestOnly;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static tool.Tools.run;

/**
 * Created by ice1000 on 2017/1/23.
 *
 * @author ice1000
 */
public class TagTest {
	@Test
	@TestOnly
	public void testToString() {
		Assert.assertEquals(
				"Van",
				new Tag("Van").getName()
		);
		Random random = new Random(System.currentTimeMillis());
		run(1000, () -> {
			String s = Integer.toString(random.nextInt());
			assertEquals(s, new Tag(s).toString());
		});
	}
}
package db.obj;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ice1000 on 2017/1/23.
 *
 * @author ice1000
 */
public class WriterTypeTest {
	@Test
	public void fromInt() throws Exception {
		assertEquals(0, WriterType.fromInt(0).getPowerLevel());
		assertEquals(1, WriterType.fromInt(1).getPowerLevel());
	}

	@Test
	public void testToString() throws Exception {
		assertEquals("0", WriterType.fromInt(0).toString());
		assertEquals("1", WriterType.fromInt(1).toString());
	}

}
package dotest.obj;

import db.obj.Pair;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ice1000 on 2017/1/23.
 */
public class PairTest {
	@Test
	public void getKey() throws Exception {
		Assert.assertEquals("Boy", new Pair("Boy", "NextDoor").getKey());
	}

	@Test
	public void getValue() throws Exception {
		assertEquals("NextDoor", new Pair("Boy", "NextDoor").getValue());
	}

	@Test
	public void getCombined() throws Exception {
		assertEquals("Boy NextDoor", new Pair("Boy", "NextDoor").getCombined());
	}

	@Test
	public void convert() throws Exception {
		// already tested in MySqlTests
		// so there's no need for this test.
		Pair pair = new Pair("Ass", "WeCan");
		assertEquals(pair.toString(), Pair.convert(pair)[0]);
	}

}
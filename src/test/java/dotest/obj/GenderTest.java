package dotest.obj;

import db.obj.Gender;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ice1000 on 2017/1/23.
 *
 * @author ice1000
 */
public class GenderTest {
	@Test
	public void getNumber() throws Exception {
		Assert.assertEquals(
				Gender.MALE.getNumber(),
				Gender.fromInt(1).getNumber()
		);
		assertEquals(
				Gender.SECRET.getNumber(),
				Gender.fromInt(0).getNumber()
		);
		assertEquals(
				Gender.FEMALE.getNumber(),
				Gender.fromInt(-1).getNumber()
		);
	}

	@Test
	public void getRepresentation() throws Exception {
		assertEquals(
				Gender.MALE.getRepresentation(),
				Gender.fromInt(1).getRepresentation()
		);
		assertEquals(
				Gender.SECRET.getRepresentation(),
				Gender.fromInt(0).getRepresentation()
		);
		assertEquals(
				Gender.FEMALE.getRepresentation(),
				Gender.fromInt(-1).getRepresentation()
		);
	}

}
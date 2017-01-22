package test.util;

import org.junit.Test;

import java.sql.SQLException;

import static test.util.TestTools.forceRun;
import static test.util.TestTools.run;

/**
 * Created by ice1000 on 2017/1/20.
 *
 * @author ice1000
 */
public class ExampleTest {
	@Test(timeout = 1000)
	public void example() throws Exception {
		run(10, () -> System.out.println("boy next door"));
		forceRun(() -> {
			throw new SQLException();
		});
	}
}

package util;

import org.junit.Test;

import static util.TestTools.run;

/**
 * Created by ice1000 on 2017/1/20.
 */
public class ExampleTest {
	@Test(timeout = 1000)
	public void example() throws Exception {
		run(10, () -> {
			System.out.println("boy next door");
		});
	}
}

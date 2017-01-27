package test.servlet;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.junit.Test;

/**
 * Created by Eldath on 2017/1/27 0027.
 *
 * @author Eldath
 */
public class Counter {
	@Test
	public void test() {
		Connection con = Jsoup.connect("http://localhost/api/v0/misc/counter")
				.data("action", "RD").data("counterpool", "001").data("counterid","1");
	}
}

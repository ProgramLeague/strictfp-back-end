package test.servlet;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Eldath on 2017/1/24 0024.
 *
 * @author Eldath
 */
public class Heartbeat {

	@Test(timeout = 500)
	public void test() throws IOException {
		Connection con = Jsoup.connect("http://localhost/api/v0/misc/heartbeat").timeout(8000);
		Document doc = con.get();
		assertEquals(doc.text(), "");
	}
}

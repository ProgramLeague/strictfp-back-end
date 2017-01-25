package test.servlet;

import org.jetbrains.annotations.TestOnly;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Eldath on 2017/1/20 0020.
 *
 * @author Eldath
 */
public class TimeLine {
	@Test
	@TestOnly
	public void test() throws IOException {
		Connection con = Jsoup.connect("http://localhost:40000/strictfp/timeline")
				.data("start", "2017-01-01")
				.data("end", "2017-01-02").timeout(8000);
		Document doc = con.get();
		System.out.println(doc.text());
	}
}

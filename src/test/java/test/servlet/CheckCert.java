package test.servlet;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class CheckCert {
	public static void main(String[] args) throws IOException {
		Connection con = Jsoup.connect("http://localhost:233/api/v0/check").data("start", "2017-01-01")
				.data("end", "2017-01-02").timeout(80000);
		Document doc = con.get();
		System.out.println(doc.text());
	}
}
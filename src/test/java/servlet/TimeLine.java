package servlet;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Eldath on 2017/1/20 0020.
 *
 * @author Eldath
 */
public class TimeLine {
	public static void main(String[] args) throws IOException {
		//使用jsoup获取jetty连接
		Connection con = Jsoup.connect("http://localhost:80/api/v0/timeline?start=20170101&end=20170102&timelineid=0").timeout(80000);
		Document doc = con.get();
		System.out.println(doc.text());
	}
}

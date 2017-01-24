package test.servlet;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class CheckCert {

	@Test(timeout = 7500)
	public void test() throws IOException {
		//FIXME 无法执行。存在405错误。
		Base64.Encoder encoder = Base64.getEncoder();
		Connection con = Jsoup.connect("http://localhost/api/v0/auth/check_cert")
				.data("uname", encoder.encodeToString("磷".getBytes(StandardCharsets.UTF_8)))
				.data("email", encoder.encodeToString("lizhaohan001@live.cn".getBytes(StandardCharsets.UTF_8)))
				.data("zhihu", encoder.encodeToString("ice1000".getBytes(StandardCharsets.UTF_8)))
				.data("github", encoder.encodeToString("Ray-Eldath".getBytes(StandardCharsets.UTF_8)))
				.data("stackoverflow", encoder.encodeToString("VonC".getBytes(StandardCharsets.UTF_8)))
				.data("brief", encoder.encodeToString("测试".getBytes(StandardCharsets.UTF_8)))
				.data("introduce", encoder.encodeToString("测试lalala".getBytes(StandardCharsets.UTF_8)))
				.timeout(8000);
		Document doc = con.get();
		System.out.println(doc.text());
	}
}
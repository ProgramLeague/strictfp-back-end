package test.servlet;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.Assert.assertEquals;

/**
 * Created by Eldath on 2017/1/24 0024.
 *
 * @author Eldath
 */
public class SafeCheck {

	@Test(timeout = 6000)
	public void test() throws IOException {
		Connection con = Jsoup.connect("http://localhost/api/v0/misc/safecheck").data("url",
				Base64.getEncoder().encodeToString("http://www.alphamedical02.fr/".
						getBytes(StandardCharsets.UTF_8)))
				.timeout(8000);
		Document doc = con.get();
		assertEquals(doc.text(),"{\"data\":{\"en\":{\"buttons\":[\"Back\",\"Continue with a fully compreh" +
				"ension about the risks originated from this action\"],\"message\":\"The external link you're w" +
				"illing to access is considered dangerous by the ZeuS Tracker or Malware Domain List, and the de" +
				"velopers team cannot be certain about the safety of the source of the link.\\nWe won't take " +
				"any responsibility of the influence caused by continuing accessing this link. You may choose to " +
				"stop accessing and be navigated back to our site or continue accessing, but the risks originated" +
				" from this action would be considered on your own.\\nWARNING: The website you're willing to access" +
				" has been considered harmful by ZeuS Tracker or Malware Domain List.\"},\"zh_CN\":{\"buttons\":" +
				"[\"返回\",\"我已了解此行为所带来的风险并继续 \"],\"message\":\"此外链已被ZeuS Tracker或Malware Domain L" +
				"ist标注为危险网站，且开发团队无法保证此网站的安全性。\\n我们对继续访问此危险网站所致的后果不承担任何责任，您可以" +
				"选择返回或继续访问，但这将意味着您必须承担此行为所带来的风险。\\n警告：您所访问的网站已被ZeuS Tracker或Malwar" +
				"e Domain List确认为危险网站。\\n\"}},\"meta\":{\"code\":\"200\",\"message\":\"hazard query success\"}}");
	}
}

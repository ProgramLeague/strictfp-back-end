package test.extern;

import org.jetbrains.annotations.TestOnly;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ice1000 on 2017/1/23.
 *
 * @author ice1000
 */
public class UrlTest {
	/**
	 * @throws MalformedURLException fuck it
	 * @see URL#toString()
	 */
	@Test
	@TestOnly
	public void testUrlToString() throws MalformedURLException {
		System.out.println(new URL("https://github.com").toString());
	}
}

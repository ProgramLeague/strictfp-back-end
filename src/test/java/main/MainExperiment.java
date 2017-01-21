package main;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class MainExperiment {

	// 绝对不准弄Test！！！
	// 好好好 你牛逼你牛逼
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.zhihu.com/");
		System.out.println(url.getProtocol());
	}
}

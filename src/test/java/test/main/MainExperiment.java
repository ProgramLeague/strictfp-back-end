package test.main;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class MainExperiment {

	// 绝对不准弄Test！！！
	// 好好好 你牛逼你牛逼
	public static void main(String[] args) throws IOException {
		String name = "www.baidu.com";
		InetAddress[] addresses = InetAddress.getAllByName(name);
		for (int i = 0; i < addresses.length; i++) {
			System.out.println(name + "[" + i + "]: " + addresses[i].getHostAddress());
		}
	}
}

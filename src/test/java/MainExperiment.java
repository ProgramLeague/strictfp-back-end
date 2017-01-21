import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created by Eldath on 2017/1/21 0021.
 *
 * @author Eldath
 */
public class MainExperiment {

	// 绝对不准弄Test！！！
	public static void main(String[] args) throws IOException {
		BASE64Encoder encoder = new BASE64Encoder();
		BASE64Decoder decoder = new BASE64Decoder();
		String str = "test only";
		String encoded = encoder.encode(str.getBytes());
		System.out.println("Encoded value is " + encoded);
		byte[] valueDecoded = decoder.decodeBuffer(encoded);
		System.out.println("Decoded value is " + new String(valueDecoded));
	}
}

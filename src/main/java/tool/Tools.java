package tool;

import com.sun.xml.internal.messaging.saaj.util.CharReader;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import java.io.CharArrayReader;
import java.io.IOException;

/**
 * Created by ice1000 on 2017/1/22.
 *
 * @author ice1000
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Tools {
	public static int getValidNumber(@NotNull @Nls char[] content) {
		try {
			CharArrayReader reader = new CharReader(content, content.length);
			int result = 0;
			int current = reader.read();
			while (!(current >= '0' && current <= '9')) current = reader.read();
			while (current >= '0' && current <= '9') {
				result = (result << 3) + (result << 1) + (current - '0'); // equal to result * 10
				current = reader.read();
			}
			reader.close();
			return result;
		} catch (IOException e) {
			throw new RuntimeException("boy next door", e);
		}
	}
}

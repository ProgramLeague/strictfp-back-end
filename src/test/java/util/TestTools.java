package util;

/**
 * Created by ice1000 on 2017/1/20.
 *
 * @author ice1000
 */
public class TestTools {
	public static void run(int times, Func function) {
		for (int i = 0; i < times; ++i) function.invoke();
	}

	public interface Func {
		void invoke();
	}
}

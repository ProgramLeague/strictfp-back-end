package test.util;

/**
 * Created by ice1000 on 2017/1/20.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public class TestTools {
	/**
	 * run a code block many times.
	 *
	 * @param times    times of execution
	 * @param function code block
	 */
	public static void run(int times, Func function) {
		for (int i = 0; i < times; ++i) forceRun(function);
	}

	/**
	 * force execute a code block
	 * without catching the fucking exception
	 *
	 * @param func code block
	 */
	public static void forceRun(Func func) {
		try {
			func.invoke();
		} catch (Throwable ignored) {
		}
	}

	public interface Func {
		void invoke() throws Exception;
	}
}

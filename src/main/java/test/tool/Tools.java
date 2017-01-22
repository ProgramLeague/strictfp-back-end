package test.tool;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ice1000 on 2017/1/22.
 *
 * @author ice1000
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Tools {

	/**
	 * an OI-style reading method
	 *
	 * @param content raw
	 * @return parsed int
	 */
	@Contract(pure = true)
	public static int getValidNumber(@NotNull @NonNls char[] content) {
		int index = 0;
		int result = 0;
		int current = content[index++];
		while (!(current >= '0' && current <= '9')) current = content[index++];
		while (index <= content.length && current >= '0' && current <= '9') {
			result = (result << 3) + (result << 1) + (current - '0'); // equal to result * 10
			if (index >= content.length) break;
			current = content[index++];
		}
		return result;
	}

	public static int getValidNumber(@NotNull @NonNls String content) {
		return getValidNumber(content.toCharArray());
	}

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

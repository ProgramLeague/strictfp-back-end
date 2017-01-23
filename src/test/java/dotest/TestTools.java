package dotest;

import org.junit.Test;
import tool.Tools;

import java.util.Random;

import static org.junit.Assert.assertEquals;

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

	@Test(timeout = 2000)
	public void getValidNumber() throws Exception {
		System.out.println("TestTools start");
		assertEquals(2333, Tools.getValidNumber("2333"));
		final Random random = new Random(System.currentTimeMillis());
		run(1000, () -> {
			int nextInt = random.nextInt(23333333);
			assertEquals(
					nextInt,
					Tools.getValidNumber("boyNextDoor" + nextInt + "assWeCan")
			);
		});
		System.out.println("└─Finish TestTools");
	}

	public interface Func {
		void invoke() throws Exception;
	}
}

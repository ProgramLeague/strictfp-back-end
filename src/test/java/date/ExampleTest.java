package date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by ice1000 on 2017/1/17.
 *
 * @author ice1000
 */
public class ExampleTest {
	@Test(timeout = 1000)
	public void example() {
		System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_DATE));

	}
}

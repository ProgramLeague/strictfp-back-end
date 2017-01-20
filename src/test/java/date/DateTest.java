package date;

/**
 * Created by Eldath on 2017/1/19 0019.
 *
 * @author Eldath
 */
public class DateTest {
	public static void main(String[] args) {
		int date = 20170103;
		String dateString = String.valueOf(date);
		StringBuilder sb = new StringBuilder();
		sb.append(dateString.substring(0, 4)).append("-").append(dateString.substring(4, 6)).append("-").substring(7, dateString.length());
		System.out.println(sb.toString());
		//System.out.println(LocalDate.parse(String.valueOf(date)));
	}
}

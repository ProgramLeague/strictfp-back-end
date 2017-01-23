package dotest;

import db.obj.Article;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Created by ice1000 on 2017/1/20.
 *
 * @author ice1000
 */
public class ArticleTest {
	@Test(timeout = 100)
	public void testDateParser() throws Exception {
		assertEquals("2017-01-20", Article.parseDate(20170120));
		assertEquals("2017-11-22", Article.parseDate(20171122));
	}

	/**
	 * never use test.main function in testing.
	 */
	public static void main(String[] args) {
		System.out.println(LocalDate.now().toString());
	}
}
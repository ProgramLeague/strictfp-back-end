package db;

import db.obj.Pair;
import org.jetbrains.annotations.TestOnly;
import org.junit.Test;

/**
 * Created by ice1000 on 2017/1/19.
 *
 * @author ice1000
 */
public class MySqlAdapterTest {
	/**
	 * test passed
	 *
	 * @throws Exception is a rubbish
	 */
	@Test
	@TestOnly
	public void insert() throws Exception {
		DatabaseAdapter adapter = MySqlAdapter.getInstance();
		adapter.insert(
				"article",
				"1,20170101,0,'Tech, Startalk','Tech','How to mo the older?','Tech you how to mo the older'," +
						"'Mo is the best way to increase your knowledge.',10000,0,1000",
				"2,20170101,0,'Tech, Startalk','Tech','How to mo the older?'," +
						"'Tech you how to mo the older','Mo is the best way to increase your knowledge.',10000,0,10000"
		);
//		System.out.println("INSERT INTO `article` VALUES (" +
//				"1,20170101,0,'Tech, Startalk','Tech','How to mo the older?','Tech you how to mo the older'," +
//				"'Mo is the best way to increase your knowledge.',10000,0,1000" +
//				"),(" +
//				"2,20170101,0,'Tech, Startalk','Tech','How to mo the older?'," +
//				"'Tech you how to mo the older','Mo is the best way to increase your knowledge.',10000,0,10000);"
//		);
	}

	/**
	 * test passed
	 *
	 * @throws Exception is a rubbish
	 */
	@Test
	@TestOnly
	public void update() throws Exception {
		MySqlAdapter.getInstance().update(
				"article",
				new Pair[]{new Pair("click", "=23333")},
				new Pair("Id", ">=1")
		);
		/*
		 * the above operation will generate query string as below
		 * this is a simple example
		 * but I think you can understand it
		 */
		String testStr = "UPDATE article SET click=23333 WHERE Id>=1";
	}

	@Test
	@TestOnly
	public void delete() throws Exception {
		MySqlAdapter.getInstance().delete(
				"article",
				new Pair("Id", "=1")
		);
		/*
		 * the above code shows how to delete elements from
		 * a table.
		 * I think you guys can understand that.
		 * LOL
		 */
	}

	@Test
	@TestOnly
	public void select() throws Exception {

	}

}

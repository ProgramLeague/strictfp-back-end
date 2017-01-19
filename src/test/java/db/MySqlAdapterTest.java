package db;

import db.obj.Pair;
import org.junit.Test;

/**
 * Created by ice1000 on 2017/1/19.
 */
public class MySqlAdapterTest {
	@Test
	public void insert() throws Exception {
	}

	@Test
	public void update() throws Exception {
		MySqlAdapter.getInstance().update(
				"items",
				new Pair[]{new Pair("price", "= 233")},
				new Pair("id", ">=100")
		);
		/*
		 * the above operation will generate query string as below
		 * this is a simple example
		 * but I think you can understand it
		 */
		String testStr = "UPDATE items SET price=233 WHERE id>=100";
	}

	@Test
	public void delete() throws Exception {

	}

	@Test
	public void select() throws Exception {

	}

}
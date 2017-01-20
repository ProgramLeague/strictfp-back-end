package db;

import db.obj.Pair;
import org.junit.Test;

/**
 * Created by ice1000 on 2017/1/19.
 */
public class MySqlAdapterTest {
	@Test
	public void insert() throws Exception {
		DatabaseAdapter adapter = MySqlAdapter.getInstance();
		adapter.insert(
				"article",
				""
		);
	}

	@Test
	public void update() throws Exception {
		MySqlAdapter.getInstance().update(
				"article",
				new Pair[]{new Pair("Id", "=100")},
				new Pair("up", ">= 1")
		);
		/*
		 * the above operation will generate query string as below
		 * this is a simple example
		 * but I think you can understand it
		 */
		String testStr = "UPDATE article SET Id=100 WHERE up>=1";
	}

	@Test
	public void delete() throws Exception {

	}

	@Test
	public void select() throws Exception {

	}

}
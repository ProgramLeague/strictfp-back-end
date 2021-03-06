package test;

import org.junit.Test;
import tool.Configurations;

import static org.junit.Assert.assertEquals;

/**
 * Created by ice1000 on 2017/1/24.
 *
 * @author ice1000
 */
public class ConfigurationsTest {
	@Test
	public void insert() throws Exception {
		Configurations.getSharedInstance().insert("DATABASE_HOST", "localhost");
		Configurations.getSharedInstance().insert("DATABASE_NAME", "strictfp");
		Configurations.getSharedInstance().insert("DATABASE_PORT", "3306");
		System.out.println(Configurations.getSharedInstance().query("DATABASE_PORT"));
		Configurations.getSharedInstance().insert("DATABASE_PASSWORD", "root");
		Configurations.getSharedInstance().insert("DATABASE_USERNAME", "root");
		Configurations.getSharedInstance().insert("SERVER_PORT", "30000");
		Configurations.getSharedInstance().insert("PATH_TO_BLOCK_LIST", "res/block_list.txt");
	}

	@Test
	public void query() throws Exception {
		insert();
		Configurations configurations = Configurations.getSharedInstance();
		assertEquals("3306", configurations.query("DATABASE_PORT"));
//		assertEquals("Have sex with ice1000", configurations.query("dream"));
	}

}
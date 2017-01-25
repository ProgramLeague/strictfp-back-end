package dotest;

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
		Configurations configurations = new Configurations("res/config.conf");
		configurations.insert("DATABASE_HOST", "localhost");
		configurations.insert("DATABASE_NAME", "strictfp");
		configurations.insert("DATABASE_PORT", "3306");
		configurations.insert("DATABASE_PASSWORD", "root");
		configurations.insert("DATABASE_USERNAME", "root");
		configurations.insert("SERVER_PORT", "30000");
		configurations.insert("PATH_TO_BLOCK_LIST", "res/block_list.txt");
	}

	@Test
	public void query() throws Exception {
		insert();
		Configurations configurations = new Configurations("res/config.conf");
		assertEquals("Eldath", configurations.query("name"));
		assertEquals("Have sex with ice1000", configurations.query("dream"));
	}

}
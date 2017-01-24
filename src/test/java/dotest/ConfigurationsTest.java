package dotest;

import org.junit.Test;
import tool.Configurations;

import static org.junit.Assert.assertEquals;

/**
 * Created by ice1000 on 2017/1/24.
 */
public class ConfigurationsTest {
	@Test
	public void insert() throws Exception {
		Configurations configurations = new Configurations("save.txt");
		configurations.insert("name", "Eldath");
		configurations.insert("gender", "Female");
		configurations.insert("dream", "Have sex with ice1000");
	}

	@Test
	public void query() throws Exception {
		insert();
		Configurations configurations = new Configurations("save.txt");
		assertEquals("Eldath", configurations.query("name"));
		assertEquals("Have sex with ice1000", configurations.query("dream"));
	}

}
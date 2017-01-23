package test.db;

import db.DatabaseAdapter;
import db.obj.Pair;
import org.apache.log4j.PropertyConfigurator;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Eldath on 2017/1/23 0023.
 *
 * @author Eldath
 */
public class QuizTest {
	public static void main(String[] args) throws SQLException {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\log4j.properties");
		DatabaseAdapter adapter = DatabaseAdapter.currentlyUsingAdapterInstance();
		ResultSet resultSet = adapter.select("quiz", new Pair("Id", "=1"));
		resultSet.next();
		System.out.println(resultSet.getString("answer").charAt(0));
	}
}

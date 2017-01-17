package db;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Eldath on 2017/1/17 0017.
 *
 * @author Eldath
 */
public class DatabaseAdapter implements DatabaseAdapterInterface {
	@Nullable
	private static DatabaseAdapter instance;

	/**
	 * sql url
	 * I don't know how 2 solve this ATM
	 */
	private static final String URL =
			"jdbc:mysql://localhost:80/javademo?";

	private Statement statement;

	private DatabaseAdapter() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			statement = DriverManager.getConnection(URL).createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@NotNull
	public DatabaseAdapterInterface getInstance() {
		if (instance == null) instance = new DatabaseAdapter();
		return instance;
	}

	@Override
	public synchronized boolean insert(@NotNull String input) throws SQLException {
		return false;
	}

	@Override
	public synchronized boolean update(@NotNull String input) throws SQLException {
		return false;
	}

	@Override
	public synchronized boolean delete(@NotNull String input) throws SQLException {
		return false;
	}

	@NotNull
	@Override
	public List<Object> select(@NotNull @NonNls String sql) throws SQLException {
		return null;
	}

	@Override
	public void execSQL(@NotNull @NonNls String sql) throws SQLException {
		statement.execute(sql);
	}

	@NotNull
	@Override
	public List<Object> selectAll(@NotNull @NonNls String formName) throws SQLException {
		return null;
	}
}

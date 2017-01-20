package db;

import db.obj.Pair;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Eldath on 2017/1/17 0017.
 *
 * @author Eldath
 */
public class MySqlAdapter implements
		DatabaseAdapter {
	@Nullable
	private static MySqlAdapter instance;

	@NotNull
	@NonNls
	private static final String DEFAULT_URL =
			"jdbc:mysql://localhost:3306/main";

	@NotNull
	private final Statement statement;

	private MySqlAdapter(String url) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			statement = DriverManager.getConnection(url).createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("database cannot connect error!");
		}
	}

	@NotNull
	static MySqlAdapter getInstance() {
		if (instance == null) instance = new MySqlAdapter(DEFAULT_URL);
		return instance;
	}

	@Override
	public boolean insert(
			@NotNull @NonNls String tableName,
			@NotNull @NonNls String... value) {
		try {
			String boyNextDoor = "INSERT INTO " + tableName + " VALUES ( ";
			for (String val : value) execSQL(boyNextDoor + val + " )");
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	@Override
	public boolean update(
			@NotNull @NonNls String tableName,
			@Nullable Pair[] where,
			@Nullable Pair... after) {
		// TODO
		try {
			execSQL("UPDATE " +
					tableName +
					" SET " +
					String.join(" , ", Pair.convert(after)) +
					" WHERE " +
					String.join(" , ", Pair.convert(where)));
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	@Override
	public boolean delete(
			@NotNull @NonNls String tableName,
			@Nullable Pair... where) {
		// TODO
		try {
			StringBuilder stringBuilder = new StringBuilder();
			execSQL(stringBuilder.toString());
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	@NotNull
	@NonNls
	@Override
	public String getQueryString(
			@NotNull @NonNls String tableName,
			@Nullable @NonNls String columnName) {
		return "SELECT " +
				(columnName != null ? columnName : "*") +
				" FROM " +
				tableName;
	}

	@NotNull
	@Override
	public ResultSet select(
			@NotNull @NonNls String tableName,
			@Nullable @NonNls String columnName,
			@Nullable Pair... where) {
		StringBuilder stringBuilder = new StringBuilder()
				.append(getQueryString(tableName, columnName));
		if (where != null) {
			stringBuilder
					.append(" WHERE ")
					.append(String.join(" AND ", Pair.convert(where)));
		}
		return execSQL(stringBuilder.toString());
/*
return statement.executeQuery("SELECT " +
		(columnName != null ? columnName : "*") +
		" FROM " + tableName +
		" WHERE " + String.join(" and ", Pair.convert(where))
		);
// NOTICE: HERE I IGNORED THE CASE THAT WHERE IS NULL
*/
	}

	@NotNull
	@Override
	public ResultSet execSQL(
			@NotNull @NonNls String sql) {
		try {
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("sql error!");
		}
	}

	@Override
	public void close() {
		try {
			statement.close();
			instance = null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("sql error!");
		}
	}
}

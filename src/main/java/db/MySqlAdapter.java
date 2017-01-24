package db;

import db.obj.Pair;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tool.Constant;

import java.sql.*;

/**
 * Created by Eldath on 2017/1/17 0017.
 *
 * @author Eldath
 */
@SuppressWarnings("WeakerAccess")
public class MySqlAdapter implements
		DatabaseAdapter {
	private static final Logger logger = LoggerFactory.getLogger(MySqlAdapter.class);
	@Nullable
	private static MySqlAdapter instance;

	@NotNull
	@NonNls
	private static final String DEFAULT_URL =
			"jdbc:mysql://" + Constant.DATABASE_HOST + ":3306/" + Constant.DATABASE_NAME + "?serverTimezone=UTC";
	@NotNull
	@NonNls
	private static final String user = "root";

	@NotNull
	@NonNls
	private static final String password = "root";

	@NotNull
	private final Statement statement;
	@NotNull
	private final Connection connection;

	private MySqlAdapter(@NotNull @NonNls String url) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(false);
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("cannot connect to the database!");
		}
	}

	@NotNull
	public static MySqlAdapter getInstance() {
		if (instance == null) instance = new MySqlAdapter(DEFAULT_URL);
		return instance;
	}

	@Override
	public synchronized boolean insert(
			@NotNull @NonNls String tableName,
			@NotNull @NonNls String... value) {
		// TODO unsafe , needs to be fixed - phosphorus15
		try {
//			PreparedStatement preparedStatement = connection.prepareStatement();
			String boyNextDoor = "INSERT INTO " + tableName + " VALUES ( ";
			for (String val : value) execSQL(boyNextDoor + val + " )");
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	@Override
	public synchronized boolean update(
			@NotNull @NonNls String tableName,
			@NotNull Pair[] after,
			@Nullable Pair... where) {
		try {
			StringBuilder boyNextDoor = new StringBuilder()
					.append("UPDATE ")
					.append(tableName)
					.append(" SET ")
					.append(String.join(" , ", (CharSequence[]) Pair.convert(after)));
			if (where != null) {
				boyNextDoor
						.append(" WHERE ")
						.append(String.join(" , ", (CharSequence[]) Pair.convert(where)));
			}
			return execSQL(boyNextDoor.toString());
		} catch (RuntimeException e) {
			return false;
		}
	}

	@Override
	public boolean delete(
			@NotNull @NonNls String tableName,
			@Nullable Pair... where) {
		try {
			StringBuilder boyNextDoor = new StringBuilder("DELETE FROM ")
					.append(tableName);
			if (where != null) {
				boyNextDoor
						.append(" WHERE ")
						.append(String.join(" , ", (CharSequence[]) Pair.convert(where)));
			}
			return execSQL(boyNextDoor.toString());
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
		StringBuilder deepDarkFantasy = new StringBuilder(getQueryString(tableName, columnName));
		if (where != null) {
			deepDarkFantasy
					.append(" WHERE ")
					.append(String.join(" AND ", (CharSequence[]) Pair.convert(where)));
		}
		return querySQL(deepDarkFantasy.toString());
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
	public ResultSet querySQL(
			@NotNull @NonNls String sql) {
		try {
			logger.info("Run SQL statement: " + sql);
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("sql error!");
		}
	}

	public boolean execSQL(
			@NotNull @NonNls String sql) {
		try {
			logger.info("Run SQL statement: " + sql);
			return statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("sql error!");
		}
	}

	@Override
	public void close() {
		try {
			statement.close();
			connection.close();
			instance = null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("sql error!");
		}
	}
}

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
public class MySqlAdapter implements DatabaseAdapterInterface {
	@Nullable
	private static MySqlAdapter instance;

	@NotNull
	@NonNls
	private static final String URL = "";

	@NotNull
	private final Statement statement;

	private MySqlAdapter() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			statement = DriverManager.getConnection(URL).createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("database cannot connect error!");
		}
	}

	@NotNull
	public static MySqlAdapter getInstance() {
		if (instance == null) instance = new MySqlAdapter();
		return instance;
	}

	@Override
	public boolean insert(
			@NotNull @NonNls String formName,
			@NotNull @NonNls String... value) {
		return false;
	}

	@Override
	public boolean update(
			@NotNull @NonNls String formName,
			@NotNull Pair where,
			@NotNull Pair... toSet) {
		return false;
	}

	@Override
	public boolean delete(
			@NotNull @NonNls String formName,
			@NotNull Pair... where) {
		return false;
	}

	@NotNull
	@Override
	public ResultSet select(
			@NotNull @NonNls String formName,
			@NotNull @NonNls String columnName) {
		return null;
	}

	@NotNull
	@Override
	public ResultSet select(
			@NotNull @NonNls String formName,
			@Nullable @NonNls String columnName,
			@Nullable Pair... where) {
		try {
			return statement.executeQuery("SELECT " +
					((columnName == null) ? "*" : columnName) +
					" FROM " + formName + " WHERE "
			);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("MySQL error!");
		}
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

	@NotNull
	@Override
	public ResultSet selectAll(
			@NotNull @NonNls String formName) {
		return null;
	}
}

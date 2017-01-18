package db;

import db.obj.Pair;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by Eldath on 2017/1/17 0017.
 *
 * @author Eldath
 */
public class MySqlAdapter implements DatabaseAdapterInterface {
	@Nullable
	private static MySqlAdapter instance;

	private MySqlAdapter() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@NotNull
	public static MySqlAdapter getInstance() {
		if (instance == null) instance = new MySqlAdapter();
		return instance;
	}

	@Override
	public boolean insert(
			@NotNull String formName,
			@NotNull @NonNls String... value) {
		return false;
	}

	@Override
	public boolean update(
			@NotNull String formName,
			@NotNull Pair where,
			@NotNull Pair... toSet) {
		return false;
	}

	@Override
	public boolean delete(@NotNull String formName, Pair where) {
		return false;
	}

	@NotNull
	@Override
	public List<Object> select(@NotNull @NonNls String formName, @NotNull @NonNls String columnName) {
		return null;
	}

	@Override
	public void execSQL(@NotNull @NonNls String sql) {

	}

	@NotNull
	@Override
	public List<Object> selectAll(@NotNull @NonNls String formName) {
		return null;
	}
}

package db;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by Eldath on 2017/1/17 0017.
 *
 * @author Eldath
 */
public class DatabaseAdapter implements DatabaseAdapterInterface {
	@Nullable
	private static DatabaseAdapter instance;

	private DatabaseAdapter() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
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
	public synchronized boolean insert(@NotNull String input) {
		return false;
	}

	@Override
	public synchronized boolean update(@NotNull String input) {
		return false;
	}

	@Override
	public synchronized boolean delete(@NotNull String input) {
		return false;
	}

	@NotNull
	@Override
	public List<Object> select(@NotNull @NonNls String sql) {
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

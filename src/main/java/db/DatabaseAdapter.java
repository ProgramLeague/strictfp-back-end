package db;

import db.obj.Blog;
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
		} catch (ClassNotFoundException e) {
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
	public synchronized boolean insert(@NotNull Blog input) {
		return false;
	}

	@Override
	public synchronized boolean update(@NotNull Blog input) {
		return false;
	}

	@Override
	public synchronized boolean delete(@NotNull Blog input) {
		return false;
	}

	@Override
	public List<Object> select(@NotNull @NonNls String sql) {
		return null;
	}

	@Override
	public void execSQL(@NotNull @NonNls String sql) {
	}

	@Override
	public List<Object> selectAll(@NotNull @NonNls String formName) {
		return null;
	}
}

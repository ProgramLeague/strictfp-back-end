package db;

import db.obj.Blog;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by Eldath on 2017/1/17 0017.
 *
 * @author Eldath
 */
public class DatabaseAdapter implements DatabaseAdapterInterface {
	public DatabaseAdapter() {
	}

	@Override
	public boolean insertBlog(@NotNull Blog input) {
		return false;
	}

	@Override
	public boolean updateBlog(@NotNull Blog input) {
		return false;
	}

	@Override
	public boolean deleteBlog(@NotNull Blog input) {
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

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
public interface DatabaseAdapterInterface {

	boolean insertBlog(@NotNull Blog input);

	boolean updateBlog(@NotNull Blog input);

	boolean deleteBlog(@NotNull Blog input);

	List<Object> select(@NotNull @NonNls String sql);

	void execSQL(@NotNull @NonNls String sql);

	List<Object> selectAll(@NotNull @NonNls String formName);
}

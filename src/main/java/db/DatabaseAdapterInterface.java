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

	@NotNull
	DatabaseAdapterInterface getInstance();

	boolean insert(@NotNull Blog input);

	boolean update(@NotNull Blog input);

	boolean delete(@NotNull Blog input);

	@NotNull
	List<Object> select(@NotNull @NonNls String sql);

	void execSQL(@NotNull @NonNls String sql);

	@NotNull
	List<Object> selectAll(@NotNull @NonNls String formName);
}

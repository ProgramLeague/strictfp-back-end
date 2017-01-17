package db;

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

	boolean insert(@NotNull String input);

	boolean update(@NotNull String input);

	boolean delete(@NotNull String input);

	@NotNull
	List<Object> select(@NotNull @NonNls String sql);

	void execSQL(@NotNull @NonNls String sql);

	@NotNull
	List<Object> selectAll(@NotNull @NonNls String formName);
}

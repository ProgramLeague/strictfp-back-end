package db;

import db.obj.KeyAndValue;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by Eldath on 2017/1/17 0017.
 *
 * @author Eldath
 */
public interface DatabaseAdapterInterface {

	boolean insert(@NotNull String formName, String... value);

	boolean update(@NotNull String formName, KeyAndValue where, KeyAndValue... toSet);

	boolean delete(@NotNull String formName, KeyAndValue where);

	@NotNull
	List<Object> select(@NotNull @NonNls String formName, @NotNull @NonNls String columnName);

	void execSQL(@NotNull @NonNls String sql);

	@NotNull
	List<Object> selectAll(@NotNull @NonNls String formName);
}

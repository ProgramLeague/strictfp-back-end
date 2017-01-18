package db;

import db.obj.Pair;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;

/**
 * Created by Eldath on 2017/1/17 0017.
 *
 * @author Eldath
 */
public interface DatabaseAdapterInterface {
	boolean insert(
			@NotNull String formName,
			@NotNull @NonNls String... value);

	boolean update(
			@NotNull @NonNls String formName,
			@NotNull Pair where,
			@NotNull Pair... toSet);

	boolean delete(
			@NotNull @NonNls String formName,
			@NotNull Pair where);

	@NotNull
	ResultSet select(
			@NotNull @NonNls String formName,
			@NotNull @NonNls String columnName);

	@NotNull
	ResultSet select(
			@NotNull @NonNls String formName,
			@NotNull @NonNls String columnName,
			@NotNull Pair where);

	ResultSet execSQL(@NotNull @NonNls String sql);

	@NotNull
	ResultSet selectAll(@NotNull @NonNls String formName);
}

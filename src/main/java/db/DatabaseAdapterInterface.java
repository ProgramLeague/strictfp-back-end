package db;

import db.obj.Pair;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.ResultSet;
import java.util.Collection;

/**
 * Created by Eldath on 2017/1/17 0017.
 *
 * @author Eldath
 */
@SuppressWarnings("SameParameterValue")
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
			@NotNull Pair... where);

	@NotNull
	ResultSet select(
			@NotNull @NonNls String formName,
			@NotNull @NonNls String columnName);

	@NotNull
	ResultSet select(
			@NotNull @NonNls String formName,
			@Nullable @NonNls String columnName,
			@Nullable Pair... where);

	@NotNull
	default ResultSet select(
			@NotNull @NonNls String formName,
			@Nullable @NonNls String columnName,
			@Nullable Collection<Pair> where) {
		return select(
				formName,
				columnName,
				where != null ? (Pair[]) where.toArray() : null
		);
	}

	ResultSet execSQL(@NotNull @NonNls String sql);

	@NotNull
	ResultSet selectAll(@NotNull @NonNls String formName);
}

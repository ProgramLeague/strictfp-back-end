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
			@Nullable Pair... after);

	boolean delete(
			@NotNull @NonNls String formName,
			@Nullable Pair... where);

	@NotNull
	default ResultSet select(
			@NotNull @NonNls String formName,
			@Nullable @NonNls String columnName) {
		return select(formName, columnName, (Pair[]) null);
	}

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
	default ResultSet selectAll(@NotNull @NonNls String formName) {
		return select(formName, null);
	}
}

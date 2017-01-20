package db;

import db.obj.Pair;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Closeable;
import java.sql.ResultSet;
import java.util.Collection;

/**
 * Created by Eldath on 2017/1/17 0017.
 *
 * @author Eldath
 */
@SuppressWarnings("SameParameterValue")
public interface DatabaseAdapter extends Closeable {

	/**
	 * @param tableName table name
	 * @param value     the data
	 *                  value[i] == "1, 2, \"boy\""
	 *                  value[2] = "5, 24, \"fuck\""
	 *                  like that
	 * @return if exception is not thrown
	 */
	boolean insert(
			@NotNull String tableName,
			@NotNull @NonNls String... value);

	boolean update(
			@NotNull @NonNls String tableName,
			@NotNull Pair[] after,
			@Nullable Pair... where);

	default boolean update(
			@NotNull @NonNls String tableName,
			@NotNull Pair[] after) {
		return update(tableName, after, (Pair[]) null);
	}

	boolean delete(
			@NotNull @NonNls String tableName,
			@Nullable Pair... where);

	@NotNull
	default ResultSet select(
			@NotNull @NonNls String tableName,
			@Nullable @NonNls String columnName) {
		return select(tableName, columnName, (Pair[]) null);
	}

	@NotNull
	default ResultSet selectWithExtraInfo(
			@NotNull @NonNls String tableName,
			@Nullable @NonNls String columnName,
			@NotNull @NonNls String extraInfo) {
		return querySQL(getQueryString(tableName, columnName) + extraInfo);
	}

	@NonNls
	@NotNull
	String getQueryString(
			@NotNull @NonNls String tableName,
			@Nullable @NonNls String columnName);

	/**
	 * this is the most complex one of all 'select's.
	 *
	 * @param tableName  the name of table
	 * @param columnName the column you wanna search
	 * @param where      the conditions
	 * @return query result
	 * @throws RuntimeException if SQLException is thrown
	 *                          // fuck checked exception
	 */
	@NotNull
	ResultSet select(
			@NotNull @NonNls String tableName,
			@Nullable @NonNls String columnName,
			@Nullable Pair... where);

	@NotNull
	default ResultSet select(
			@NotNull @NonNls String tableName,
			@Nullable Pair... where) {
		return select(tableName, null, where);
	}

	@NotNull
	default ResultSet select(
			@NotNull @NonNls String tableName,
			@Nullable Collection<Pair> where) {
		return select(tableName, null, where);
	}

	@NotNull
	default ResultSet select(
			@NotNull @NonNls String tableName,
			@Nullable @NonNls String columnName,
			@Nullable Collection<Pair> where) {
		return select(
				tableName,
				columnName,
				where != null ? (Pair[]) where.toArray() : null
		);
	}

	@NotNull
	ResultSet querySQL(@NotNull @NonNls String sql);

	boolean execSQL(@NotNull @NonNls String sql);

	@NotNull
	default ResultSet selectAll(@NotNull @NonNls String tableName) {
		return select(
				tableName,
				null,
				(Pair[]) null
		);
	}
}

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
public interface DatabaseAdapterInterface extends Closeable {
	boolean insert(
			@NotNull String formName,
			@NotNull @NonNls String... value);

	boolean update(
			@NotNull @NonNls String formName,
			@Nullable Pair[] after,
			@Nullable Pair... where);

	boolean delete(
			@NotNull @NonNls String formName,
			@Nullable Pair... where);

	@NotNull
	default ResultSet select(
			@NotNull @NonNls String formName,
			@Nullable @NonNls String columnName) {
		return select(formName, columnName, (Pair[]) null);
	}

	/**
	 * this is the most complex one of all 'select's.
	 *
	 * @param formName   the name of form
	 * @param columnName the column you wanna search
	 * @param where      the conditions
	 * @return query result
	 * @throws RuntimeException if SQLException is thrown
	 *                          // fuck checked exception
	 */
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

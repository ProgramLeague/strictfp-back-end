package db;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Eldath on 2017/1/17 0017.
 *
 * @author Eldath
 */
public interface DatabaseAdapterInterface {

	@NotNull
	DatabaseAdapterInterface getInstance() throws SQLException;

	boolean insert(@NotNull String input) throws SQLException;

	boolean update(@NotNull String input) throws SQLException;

	boolean delete(@NotNull String input) throws SQLException;

	@NotNull
	List<Object> select(@NotNull @NonNls String sql) throws SQLException;

	void execSQL(@NotNull @NonNls String sql) throws SQLException;

	@NotNull
	List<Object> selectAll(@NotNull @NonNls String formName) throws SQLException;
}

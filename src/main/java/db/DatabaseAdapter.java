package db;

import java.util.List;

/**
 * Created by Eldath on 2017/1/17 0017.
 *
 * @author Eldath
 */
public class DatabaseAdapter implements DatabaseAdapterInterface {
	public DatabaseAdapter() {
	}

	@Override
	public boolean insert(Object input) {
		return false;
	}

	@Override
	public boolean update(Object input) {
		return false;
	}

	@Override
	public boolean delete(Object input) {
		return false;
	}

	@Override
	public List<Object> select(String sql) {
		return null;
	}

	@Override
	public List<Object> selectAll(String formName) {
		return null;
	}
}

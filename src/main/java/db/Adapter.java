package db;

/**
 * Created by Eldath on 2017/1/19 0019.
 *
 * @author Eldath
 */
public class Adapter {
	private static DatabaseAdapterInterface db = MySqlAdapter.getInstance();

	public static DatabaseAdapterInterface getAdapter() {
		return db;
	}
}

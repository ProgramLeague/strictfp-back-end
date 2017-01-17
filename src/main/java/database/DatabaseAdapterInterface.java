package database;

import java.util.List;

/**
 * Created by Eldath on 2017/1/17 0017.
 *
 * @author Eldath
 */
public interface DatabaseAdapterInterface {
    boolean insert(Object input);
    boolean update(Object input);
    boolean delete(Object input);
    List<Object> select(String sql);
    List<Object> selectAll(String formName);
}

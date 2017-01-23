package db.obj;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Provides a 'toSqlString' method.
 * used to execute the SQL query string.
 * Created by ice1000 on 2017/1/23.
 *
 * @author ice1000
 */
public interface SqlObject {

	@NotNull
	@NonNls
	String toSqlString();

}

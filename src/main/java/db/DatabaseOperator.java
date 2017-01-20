package db;

import db.obj.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eldath on 2017/1/18 0018.
 *
 * @author Eldath
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class DatabaseOperator {
	@NotNull
	private static DatabaseAdapter adapter = MySqlAdapter.getInstance();

	@Contract(pure = true)
	@NotNull
	public static Article getArticle(Pair... pair) {
		try {
			ResultSet resultSet = adapter.select("article", pair);
			Article article;
			String[] tags = resultSet
					.getString("tags")
					.split(",");
			Set<Tag> tags1 = new HashSet<>();
			for (String thisTag : tags)
				tags1.add(new Tag(thisTag));
			Writer writer = getWriter(resultSet.getInt("writerId"));
			for (String thisTag : tags)
				tags1.add(new Tag(thisTag));
			article = new Article(
					resultSet.getInt("Id"),
					resultSet.getInt("pdate"),
					writer,
					tags1,
					resultSet.getString("title"),
					resultSet.getString("brief"),
					resultSet.getString("content")
			);
			return article;
		} catch (SQLException e) {
			throw new RuntimeException("SQL error", e);
		}
	}

	public static Article getArticle(int pDate) {
		return getArticle(new Pair("padte", "=" + pDate));
	}

	public static Writer getWriter(Pair... pair) {
		try {
			ResultSet writerResultSet = adapter.select("writer", pair);
			return new Writer(
					writerResultSet.getInt("Id"),
					writerResultSet.getString("name"),
					writerResultSet.getString("motto"),
					writerResultSet.getURL("avasterURL"),
					Genders.fromInt(writerResultSet.getInt("gender"))
			);
		} catch (SQLException e) {
			throw new RuntimeException("SQL error", e);
		}
	}

	public static Writer getWriter(int Id) {
		return getWriter(new Pair("Id", "=" + Id));
	}
}
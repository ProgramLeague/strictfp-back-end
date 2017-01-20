package db;

import db.obj.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

/**
 * Created by Eldath on 2017/1/18 0018.
 *
 * @author Eldath
 */
public class DatabaseOperator {
	@NotNull
	private DatabaseAdapter adapter;

	public DatabaseOperator(@NotNull DatabaseAdapter database) {
		adapter = database;
	}

	@Contract(pure = true)
	@NotNull
	public Article getArticle(int Id) {
		try {
			ResultSet resultSet = adapter.select(
					"article",
					null,
					new Pair("Id", "=" + Id)
			);
			Article article;
			String[] tags = resultSet
					.getString("tags")
					.split(",");
			HashSet<Tag> tags1 = new HashSet<>();
			for (String thisTag : tags)
				tags1.add(new Tag(thisTag));
			ResultSet writerResultSet = adapter.select(
					"writer",
					null,
					new Pair("Id", "=" + resultSet.getInt("writerId"))
			);
			Writer writer = new Writer(
					writerResultSet.getInt("Id"),
					writerResultSet.getString("name"),
					writerResultSet.getString("motto"),
					writerResultSet.getURL("avasterURL"),
					Genders.parseInt(writerResultSet.getInt("gender"))
			);
			for (String thisTag : tags)
				tags1.add(new Tag(thisTag));
			article = new Article(
					Id,
					resultSet.getInt("pdate"),
					writer,
					tags1,
					resultSet.getString("title"),
					resultSet.getString("brief"),
					resultSet.getString("content")
			);
			return article;
		} catch (SQLException e) {
			throw new RuntimeException("SQL error");
		}
	}
}
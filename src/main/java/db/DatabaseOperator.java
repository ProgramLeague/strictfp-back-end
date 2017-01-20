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
	public Article getArticle(Pair... pair) {
		try {
			ResultSet resultSet = adapter.select("article", null, pair);
			Article article;
			String[] tags = resultSet
					.getString("tags")
					.split(",");
			HashSet<Tag> tags1 = new HashSet<>();
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

	public Article getArticle(int pDate) {
		return getArticle(new Pair("padte", "=" + pDate));
	}

	public Writer getWriter(Pair... pair) {
		try {
			ResultSet writerResultSet = adapter.select("writer", null, pair);
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

	public Writer getWriter(int Id) {
		return getWriter(new Pair("Id", "=" + Id));
	}
}
package db;

import db.obj.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;
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

	@Contract(pure = true)
	@NotNull
	public static Article getArticle(Pair... pair) {
		try {
			DatabaseAdapter adapter = MySqlAdapter.getInstance();
			ResultSet resultSet = adapter.select("article", pair);
			resultSet.next();
			int Id = resultSet.getInt("Id");
			String pDate = Article.parseDate(resultSet.getInt("pdate"));
			int writerId = resultSet.getInt("writerId");
			String[] tags = resultSet.getString("tags").split(",");
			Set<Tag> tags1 = new HashSet<>();
			for (String thisTag : tags)
				tags1.add(new Tag(thisTag));
			String title = resultSet.getString("title");
			String brief = resultSet.getString("brief");
			String content = resultSet.getString("content");
			int up = resultSet.getInt("up");
			int down = resultSet.getInt("down");
			int click = resultSet.getInt("click");
			resultSet.close();
			adapter.close();
			Writer writer = getWriter(writerId);
			return new Article(Id, pDate, writer, tags1, title, brief, content);
		} catch (SQLException e) {
			throw new RuntimeException("SQL error", e);
		} catch (IOException e) {
			throw new RuntimeException("IO error", e);
		}
	}

	@NotNull
	@Contract(pure = true)
	public static Article getArticle(int pDate) {
		return getArticle(new Pair("pdate", "=" + pDate));
	}

	@NotNull
	@Contract(pure = true)
	public static Writer getWriter(Pair... pair) {
		DatabaseAdapter adapter = MySqlAdapter.getInstance();
		try {
			ResultSet writerResultSet = adapter.select("writer", pair);
			writerResultSet.next();
			int Id = writerResultSet.getInt("Id");
			String name = writerResultSet.getString("name");
			String motto = writerResultSet.getString("motto");
			URL avatarURL = writerResultSet.getURL("avatarURL");
			Gender gender = Genders.fromInt(writerResultSet.getInt("gender"));
			writerResultSet.close();
			adapter.close();
			return new Writer(Id, name, motto, avatarURL, gender);
		} catch (SQLException e) {
			throw new RuntimeException("SQL error", e);
		} catch (IOException e) {
			throw new RuntimeException("IO error", e);
		}
	}

	@NotNull
	@Contract(pure = true)
	public static Writer getWriter(int Id) {
		return getWriter(new Pair("Id", "=" + Id));
	}
}
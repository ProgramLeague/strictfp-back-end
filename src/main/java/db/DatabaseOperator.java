package db;

import db.obj.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/**
 * Created by Eldath on 2017/1/18 0018.
 *
 * @author Eldath
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class DatabaseOperator {

	@Nullable
	@Contract(pure = true)
	public static Article getArticle(Pair... pair) {
		try {
			// init
			DatabaseAdapter adapter = DatabaseAdapter.currentlyUsingAdapterInstance();
			ResultSet resultSet = adapter.select("article", pair);
			if (!resultSet.next()) return null;
			int Id = resultSet.getInt("Id");
			LocalDate pDate = resultSet.getDate("date").toLocalDate();
			int writerId = resultSet.getInt("authorId");
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
			// get value
			resultSet.close();
			adapter.close();
			Author author = getWriter(writerId);
			if (author == null) return null;
			return new Article(Id, pDate, author, tags1, title, brief, content);
		} catch (SQLException e) {
			throw new RuntimeException("SQL error", e);
		} catch (IOException e) {
			throw new RuntimeException("IO error", e);
		}
	}

	public static boolean plus1s(int articleId, boolean isPlus) {
		Article article = getArticle(new Pair("Id", "=" + articleId));
		if (article == null) return false;
		DatabaseAdapter.currentlyUsingAdapterInstance().update(
				"article",
				new Pair[]{
						isPlus
								? new Pair("up", "=" + article.getUp() + 1)
								: new Pair("down", "=" + article.getDown() + 1)
				},
				new Pair("Id", "=" + articleId)
		);
		return true;
	}

	@Nullable
	public static Quiz getQuiz(Pair pair) {
		try {
			// init
			DatabaseAdapter adapter = DatabaseAdapter.currentlyUsingAdapterInstance();
			ResultSet resultSet = adapter.select("quiz", pair);
			Vector<QuizOption> quizOptionVector = new Vector<>();
			if (!resultSet.next()) return null;
			// get value
			int id = resultSet.getInt("Id");
			int formId = resultSet.getInt("formId");
			QuizType qt = QuizType.formInt(resultSet.getInt("type"));
			String question = resultSet.getString("question");
			String options = resultSet.getString("options");
			char answer = resultSet.getString("answer").charAt(0);
			// handle value
			String[] optionSplit = options.split(",");
			for (String thisOption : optionSplit) {
				char option = thisOption.charAt(0);
				String content = thisOption.substring(2, thisOption.length());
				quizOptionVector.add(new QuizOption(option, content));
			}
			// return
			return new Quiz(id, qt, question, answer, quizOptionVector);
		} catch (SQLException e) {
			throw new RuntimeException("SQL error", e);
		}
	}

	@Nullable
	public static QuizForm getQuizForm(int idInput) {
		try {
			// init
			DatabaseAdapter adapter = DatabaseAdapter.currentlyUsingAdapterInstance();
			ResultSet resultSet = adapter.select("quiz_form", new Pair("Id", "=" + String.valueOf(idInput)));
			if (!resultSet.next()) return null;
			// get value
			int id = resultSet.getInt("Id");
			String name = resultSet.getString("name");
			String brief = resultSet.getString("brief");
			// return;
			return new QuizForm(id, name, brief, getQuiz(new Pair("formId", "=" + idInput)));
		} catch (SQLException e) {
			throw new RuntimeException("SQL error", e);
		}
	}

	@Nullable
	public static Article getArticle(LocalDate pDate) {
		return getArticle(new Pair("date", "=" + "\"" + pDate.toString() + "\""));
	}

	@Nullable
	@Contract(pure = true)
	public static Author getWriter(Pair... pair) {
		try {
			ResultSet writerResultSet = DatabaseAdapter
					.currentlyUsingAdapterInstance()
					.select("author", pair);
			if (!writerResultSet.next()) return null;
			int Id = writerResultSet.getInt("Id");
			WriterType writerType = WriterType.fromInt(writerResultSet.getInt("authorType"));
			String name = writerResultSet.getString("username");
			String motto = writerResultSet.getString("motto");
			URL avatarURL = writerResultSet.getURL("avatarURL");
			Gender gender = Gender.fromInt(writerResultSet.getInt("gender"));
			writerResultSet.close();
			DatabaseAdapter
					.currentlyUsingAdapterInstance()
					.close();
			return new Author(Id, writerType, name, motto, avatarURL, gender);
		} catch (SQLException e) {
			throw new RuntimeException("SQL error", e);
		} catch (IOException e) {
			throw new RuntimeException("IO error", e);
		}
	}

	@Contract(pure = true)
	public static Author getWriter(int Id) {
		return getWriter(new Pair("Id", "=" + Id));
	}
}
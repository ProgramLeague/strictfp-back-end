package db.obj;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * Created by Eldath on 2017/1/18 0018.
 *
 * @author Eldath
 */
@SuppressWarnings("WeakerAccess")
public class Article {
	private int up, down, chick, id;
	private
	@NotNull
	Writer writer;
	private
	@NotNull
	Set<Tag> tags;
	private
	@NotNull
	@NonNls
	String title, publishTime, brief, content;

	public Article(
			int id,
			@NotNull @NonNls String publishTime,
			@NotNull Writer writer,
			@NotNull Set<Tag> tags,
			@NotNull @NonNls String title,
			@NotNull @NonNls String brief,
			@NotNull @NonNls String content) {
		this(id, publishTime, writer, tags, title, brief, content, 0, 0, 0);
	}

	public Article(
			int id,
			@NotNull @NonNls String publishTime,
			@NotNull Writer writer,
			@NotNull Set<Tag> tags,
			@NotNull @NonNls String title,
			@NotNull @NonNls String brief,
			@NotNull @NonNls String content,
			int up,
			int down,
			int chick) {
		this.brief = brief;
		this.title = title;
		this.tags = tags;
		this.id = id;
		this.publishTime = publishTime;
		this.content = content;
		this.up = up;
		this.down = down;
		this.chick = chick;
		this.writer = writer;
	}

	@NotNull
	@Contract(pure = true)
	public static String parseDate(int dateInt) {
		return String.format(
				"%d-%02d-%02d",
				dateInt / 10000,
				dateInt % 10000 / 100,
				dateInt % 100
		);
	}

	@NotNull
	public String getTitle() {
		return title;
	}

	@NotNull
	public String getBrief() {
		return brief;
	}

	@NotNull
	public Set<Tag> getTags() {
		return tags;
	}

	public int getId() {
		return id;
	}

	@NotNull
	public String getPublishTime() {
		return publishTime;
	}

	@NotNull
	public String getContent() {
		return content;
	}

	public int getUpCount() {
		return up;
	}

	public int getDownCount() {
		return down;
	}

	public int getChickCount() {
		return chick;
	}

	@NotNull
	public Writer getWriter() {
		return writer;
	}
}

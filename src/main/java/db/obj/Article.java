package db.obj;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eldath on 2017/1/18 0018.
 *
 * @author Eldath
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Article {
	private int up, down, click, id;
	@NotNull
	private Author author;
	@NotNull
	private Set<Tag> tags;
	@NotNull
	@NonNls
	private String title, brief, content;
	@NotNull
	@NonNls
	private LocalDate publishDate;

	public Article(
			int id,
			@NotNull @NonNls LocalDate publishTime,
			@NotNull Author author,
			@NotNull Set<Tag> tags,
			@NotNull @NonNls String title,
			@NotNull @NonNls String brief,
			@NotNull @NonNls String content) {
		this(id, publishTime, author, tags, title, brief, content, 0, 0, 0);
	}

	public Article(
			int id,
			@NotNull @NonNls LocalDate publishTime,
			@NotNull Author author,
			@NotNull Set<Tag> tags,
			@NotNull @NonNls String title,
			@NotNull @NonNls String brief,
			@NotNull @NonNls String content,
			int up,
			int down,
			int click) {
		this.brief = brief;
		this.title = title;
		this.tags = tags;
		this.id = id;
		this.publishDate = publishTime;
		this.content = content;
		this.up = up;
		this.down = down;
		this.click = click;
		this.author = author;
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
	@Contract(pure = true)
	public String getTitle() {
		return title;
	}

	@NotNull
	@Contract(pure = true)
	public String getBrief() {
		return brief;
	}

	@NotNull
	@Contract(pure = true)
	public Set<String> getTags() {
		Set<String> tagSet = new HashSet<>();
		for (Tag thisTag : tags)
			tagSet.add(thisTag.getName());
		return tagSet;
	}

	@Contract(pure = true)
	public int getId() {
		return id;
	}

	@NotNull
	@Contract(pure = true)
	public LocalDate getcdate() {
		return publishDate;
	}

	@NotNull
	@Contract(pure = true)
	public String getContent() {
		return content;
	}

	@Contract(pure = true)
	public int getUp() {
		return up;
	}

	@Contract(pure = true)
	public int getDown() {
		return down;
	}

	@Contract(pure = true)
	public int getClick() {
		return click;
	}

	@NotNull
	@Contract(pure = true)
	public Author getAuthorInfo() {
		return author;
	}
}

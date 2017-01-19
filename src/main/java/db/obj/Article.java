package db.obj;

import java.util.*;

/**
 * Created by Eldath on 2017/1/18 0018.
 *
 * @author Eldath
 */
public class Article {
	private String content, title, brief;
	private int up, down, chick, id;
	private Writer writer;
	private long publishTime;
	private HashSet<Tag> tags;

	public Article(int id, long publishTime, Writer writer, HashSet<Tag> tags, String title, String brief, String content) {
		this(id, publishTime, writer, tags, title, brief, content, 0, 0, 0);
	}

	public Article(int id, long publishTime, Writer writer, HashSet<Tag> tags, String title, String brief, String content, int up, int down, int chick) {
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

	public String getTitle() {
		return title;
	}

	public String getBrief() {
		return brief;
	}


	public HashSet<Tag> getTags() {
		return tags;
	}

	public int getId() {
		return id;
	}

	public long getPublishTime() {
		return publishTime;
	}

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

	public Writer getWriter() {
		return writer;
	}
}

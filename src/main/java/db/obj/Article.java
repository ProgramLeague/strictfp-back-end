package db.obj;

/**
 * Created by Eldath on 2017/1/18 0018.
 *
 * @author Eldath
 */
public class Article {
	private String content;
	private int up, down, chick, id;
	private Writer writer;
	private long publishTime;
	private Tag[] tags;

	public Article(int id, long publishTime, Writer writer, Tag[] tags, String content) {
		this(id, publishTime, writer, tags, content, 0, 0, 0);
	}

	public Article(int id, long publishTime, Writer writer, Tag[] tags, String content, int up, int down, int chick) {
		this.tags = tags;
		this.id = id;
		this.publishTime = publishTime;
		this.content = content;
		this.up = up;
		this.down = down;
		this.chick = chick;
		this.writer = writer;
	}

	public Tag[] getTags() {
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

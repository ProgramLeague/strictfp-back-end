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

	public Article(int id, String content, long publishTime, Writer writer) {
		this(id, content, publishTime, writer, 0, 0, 0);
	}

	public Article(int id, String content, long publishTime, Writer writer, int up, int down, int chick) {
		this.id = id;
		this.publishTime = publishTime;
		this.content = content;
		this.up = up;
		this.down = down;
		this.chick = chick;
		this.writer = writer;
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

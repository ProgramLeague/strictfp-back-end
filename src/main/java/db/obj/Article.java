package db.obj;

/**
 * Created by Eldath on 2017/1/18 0018.
 *
 * @author Eldath
 */
public class Article {
	private String content;
	private int up, down, chick;
	private Writer writer;

	public Article(String content, Writer writer) {
		this(content, writer, 0, 0, 0);
	}

	public Article(String content, Writer writer, int up, int down, int chick) {
		this.content = content;
		this.up = up;
		this.down = down;
		this.chick = chick;
		this.writer = writer;
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

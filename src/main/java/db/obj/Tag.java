package db.obj;

/**
 * Created by Eldath on 2017/1/18 0018.
 *
 * @author Eldath
 */
public class Tag {
	private int id;
	private String name;

	public Tag(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}

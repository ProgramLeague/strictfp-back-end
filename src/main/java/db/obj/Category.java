package db.obj;

/**
 * Created by Eldath on 2017/1/19 0019.
 *
 * @author Eldath
 */
public class Category {
	private String name, brief;

	public Category(String name, String brief) {
		this.name = name;
		this.brief = brief;
	}

	public String getName() {
		return name;
	}

	public String getBrief() {
		return brief;
	}
}

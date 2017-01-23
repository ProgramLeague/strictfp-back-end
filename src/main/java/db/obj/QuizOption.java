package db.obj;

/**
 * Created by Eldath on 2017/1/23 0023.
 *
 * @author Eldath
 */
public class QuizOption {
	private char option;
	private String content;

	public QuizOption(char option, String content) {
		this.option = option;
		this.content = content;
	}

	public char getOption() {
		return option;
	}

	public String getContent() {
		return content;
	}
}

package db.obj;

/**
 * Created by Eldath on 2017/1/23 0023.
 *
 * @author Eldath
 */
public class QuizOption {
	private char option, answer;
	private String content;

	public QuizOption(char option, String content, char answer) {
		this.option = option;
		this.answer = answer;
		this.content = content;
	}

	public char getOption() {
		return option;
	}

	public char getAnswer() {
		return answer;
	}

	public String getContent() {
		return content;
	}
}

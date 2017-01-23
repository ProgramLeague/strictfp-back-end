package db.obj;

import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

/**
 * Created by Eldath on 2017/1/23 0023.
 *
 * @author Eldath
 */
public class Quiz {
	private String question;
	private Vector<QuizOption> optionVector;
	private char answer;
	private int id;
	private QuizType qt;

	public Quiz(int id, QuizType qt, String question, char answer, QuizOption... options) {
		this.question = question;
		this.answer = answer;
		this.id = id;
		this.qt = qt;
		Collections.addAll(this.optionVector, options);
	}

	public Quiz(int id, QuizType qt, String question, char answer, Collection<QuizOption> options) {
		this.question = question;
		this.answer = answer;
		this.id = id;
		this.qt = qt;
		optionVector.addAll(options);
	}

	public String getQuestion() {
		return question;
	}

	public boolean addOption(QuizOption option) {
		return optionVector.add(option);
	}

	public Vector<QuizOption> getOptions() {
		return this.optionVector;
	}

	public char getAnswer() {
		return answer;
	}

	public int getId() {
		return id;
	}

	public QuizType getQt() {
		return qt;
	}

}

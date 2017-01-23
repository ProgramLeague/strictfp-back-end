package db.obj;

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

	public Quiz(String question, QuizOption... options) {
		this.question = question;
		Collections.addAll(this.optionVector, options);
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
}

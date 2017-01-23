package db.obj;

import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

/**
 * Created by Eldath on 2017/1/23 0023.
 *
 * @author Eldath
 */
public class QuizForm {
	private Vector<Quiz> allQuiz;
	private int Id;
	private String quizFormName, quizFormBrief;

	public QuizForm(int id, String name, String brief, Quiz... quizzes) {
		this.Id = id;
		this.quizFormName = name;
		this.quizFormBrief = brief;
		Collections.addAll(allQuiz, quizzes);
	}

	public QuizForm(int id, String name, String brief, Collection<Quiz> quizzes) {
		this.Id = id;
		this.quizFormName = name;
		this.quizFormBrief = brief;
		allQuiz.addAll(quizzes);
	}

	public Vector<Quiz> getAllQuiz() {
		return allQuiz;
	}

	public String getQuizFormName() {
		return quizFormName;
	}

	public String getQuizFormBrief() {
		return quizFormBrief;
	}
}

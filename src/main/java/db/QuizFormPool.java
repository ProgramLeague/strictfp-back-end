package db;

import db.obj.QuizForm;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/**
 * Created by Eldath on 2017/1/23 0023.
 *
 * @author Eldath
 */
public class QuizFormPool {
	private HashMap<String, QuizForm> quizFormArrayList = null;
	private static QuizFormPool instance;

	public static QuizFormPool getInstance() {
		if (instance == null) instance = new QuizFormPool();
		return instance;
	}

	private QuizFormPool() {
		quizFormArrayList = new HashMap<>();
		int formInts[] = {1};
		for (int thisFormInt : formInts) {
			QuizForm thisQuizForm = DatabaseOperator.getQuizForm(thisFormInt);
			if (thisQuizForm == null) continue;
			addQuizForm(thisQuizForm);
		}
	}

	public HashMap<String, QuizForm> getAllQuizForm() {
		return quizFormArrayList;
	}

	public QuizForm getQuizForm(@NotNull String name) {
		return quizFormArrayList.get(name);
	}

	public void addQuizForm(@NotNull QuizForm quizForm) {
		quizFormArrayList.put(quizForm.getQuizFormName(), quizForm);
	}
}

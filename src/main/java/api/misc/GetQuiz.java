package api.misc;

import db.QuizFormPool;
import db.obj.QuizForm;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import tool.Constant;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eldath on 2017/1/23 0023.
 *
 * @author Eldath
 */
public class GetQuiz extends HttpServlet {
	private HashMap<String, QuizForm> allQuizForm;

	public GetQuiz() {
		allQuizForm = QuizFormPool.getInstance().getAllQuizForm();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		HashMap<String, Object> status = new HashMap<>();
		JSONObject object = new JSONObject();
		String quizFormName = req.getParameter("name");
		// get main data
		QuizForm qf = allQuizForm.get(quizFormName);
		// build status
		status.put("code", String.valueOf(HttpServletResponse.SC_OK));
		status.put("message", "query quiz form successful");
		status.put("extra", Constant.JSON.EMPTY_OBJECT);
		status.put("security", Constant.JSON.EMPTY_OBJECT);
		// build main object
		object.put("meta", status);
		object.put("data", qf);
		// FIXME 非测试时移去注释 （配合Configuration System把这里设计的合理一点 - 磷）
		// response.setContentType("application/json"); // specific content type
		try (ServletOutputStream out = resp.getOutputStream()) {
			out.write(resp.toString().getBytes(StandardCharsets.UTF_8));
			out.flush();
		} catch (IOException e) {
			LoggerFactory.getLogger(Counter.class).error("IOException thrown: ", e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		HashMap<String, Object> status = new HashMap<>();
		JSONArray allNameAndBrief = new JSONArray();
		JSONObject thisNameAndBrief = new JSONObject();
		JSONObject object = new JSONObject();
		// build main data
		for (Object o : allQuizForm.entrySet()) {
			Map.Entry entry = (Map.Entry) o;
			QuizForm val = (QuizForm) entry.getValue();
			thisNameAndBrief.put("name", val.getQuizFormName());
			thisNameAndBrief.put("brief", val.getQuizFormBrief());
			allNameAndBrief.put(thisNameAndBrief);
		}
		// build status
		status.put("code", String.valueOf(HttpServletResponse.SC_OK));
		status.put("message", "query all quiz form info successful");
		status.put("extra", Constant.JSON.EMPTY_OBJECT);
		status.put("security", Constant.JSON.EMPTY_OBJECT);
		// build object
		object.put("meta", status);
		object.put("data", allNameAndBrief);
		// FIXME 非测试时移去注释 （配合Configuration System把这里设计的合理一点 - 磷）
		// response.setContentType("application/json"); // specific content type
		try (ServletOutputStream out = resp.getOutputStream()) {
			out.write(resp.toString().getBytes(StandardCharsets.UTF_8));
			out.flush();
		} catch (IOException e) {
			LoggerFactory.getLogger(Counter.class).error("IOException thrown: ", e);
		}
	}
}

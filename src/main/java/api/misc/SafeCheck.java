package api.misc;

import db.DangerousWebsiteList;
import org.json.JSONArray;
import org.json.JSONObject;
import tool.Constant;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;

/**
 * Created by Eldath on 2017/1/24 0024.
 *
 * @author Eldath
 */
public class SafeCheck extends HttpServlet {
	private static final JSONObject EN_VERSION;
	private static final JSONObject ZH_CN_VERSION;

	static {
		EN_VERSION = new JSONObject();
		JSONArray buttons = new JSONArray();
		// build English version
		buttons.put("Back");
		buttons.put("Continue with a fully comprehension about the risks originated from this action");
		EN_VERSION.put("buttons", buttons);
		EN_VERSION.put("message", "The external link you're willing to access is considered dangerous by the" +
				" ZeuS Tracker or Malware Domain List, and the developers team cannot be certain about" +
				" the safety of the source of the link.\n" +
				"We won't take any responsibility of the influence caused by continuing accessing this" +
				" link. You may choose to stop accessing and be navigated back to our site or continue" +
				" accessing, but the risks originated from this action would be considered on your own.\n" +
				"WARNING: The website you're willing to access has been considered harmful by ZeuS Tracker" +
				" or Malware Domain List.");
		ZH_CN_VERSION = new JSONObject();
		JSONArray zh_CN_buttons = new JSONArray();
		// build Chinese version
		zh_CN_buttons.put("返回");
		zh_CN_buttons.put("我已了解此行为所带来的风险并继续 ");
		ZH_CN_VERSION.put("buttons", zh_CN_buttons);
		ZH_CN_VERSION.put("message", "此外链已被ZeuS Tracker或Malware Domain List标注为危险网站，" +
				"且开发团队无法保证此网站的安全性。\n" +
				"我们对继续访问此危险网站所致的后果不承担任何责任，您可以选择返回或继续访问，" +
				"但这将意味着您必须承担此行为所带来的风险。\n" +
				"警告：您所访问的网站已被ZeuS Tracker或Malware Domain List确认为危险网站。\n");
	}

	public SafeCheck() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		// init
		HashMap<String, String> status = new HashMap<>();
		JSONObject jsonObject = new JSONObject();
		try {
			String host = new URL(new String(Base64.getDecoder().decode(
					req.getParameter("url")), StandardCharsets.UTF_8))
					.getHost();
			status.put("code", String.valueOf(HttpServletResponse.SC_OK));
			status.put("message", "hazard query success");
			if (DangerousWebsiteList.getInstance().isDanger(host)) {
				jsonObject.put("en", EN_VERSION);
				jsonObject.put("zh_CN", ZH_CN_VERSION);
			} else {
				jsonObject.put("en", "Jumping now...");
				jsonObject.put("zh_CN", "正在跳转... ...");
			}
			jsonObject.put("meta", status);
			resp.setStatus(HttpServletResponse.SC_OK);
		} catch (MalformedURLException e) {
			status.put("code", String.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
			status.put("message", "url invalid");
			jsonObject.put("data", Constant.JSON.EMPTY_OBJECT);
			jsonObject.put("meta", status);
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		try (ServletOutputStream os = resp.getOutputStream()) {
			os.write(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
		}
	}
}

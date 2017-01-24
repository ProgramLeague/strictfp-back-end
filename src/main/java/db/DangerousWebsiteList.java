package db;

import org.slf4j.LoggerFactory;
import tool.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by Eldath on 2017/1/24 0024.
 *
 * @author Eldath
 */
public class DangerousWebsiteList {
	private ArrayList<String> list = new ArrayList<>();
	private static DangerousWebsiteList instance = null;
	//TODO list from: http://www.malwaredomainlist.com/ and https://zeustracker.abuse.ch/

	public static DangerousWebsiteList getInstance() {
		if (instance == null) instance = new DangerousWebsiteList();
		return instance;
	}

	private DangerousWebsiteList() {
		try (BufferedReader br = Files.newBufferedReader(Paths.get(Constant.PATH_TO_BLOCK_LIST))) {
			String thisLine;
			while ((thisLine = br.readLine()) != null)
				list.add(thisLine);
		} catch (IOException e) {
			LoggerFactory.getLogger(DangerousWebsiteList.class).error("IO exception:", e);
		}
	}

	public boolean addDangerousWebsite(String website) {
		return list.add(website);
	}

	public boolean isDanger(String website) {
		return list.contains(website);
	}
}

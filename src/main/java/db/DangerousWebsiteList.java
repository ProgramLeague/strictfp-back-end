package db;

import org.slf4j.LoggerFactory;

import java.net.URI;
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
		try {
			ArrayList<String> strings = new ArrayList<>(Files.readAllLines(Paths.get(
					new URI("https://coding.net/u/ice1000/p/Images/git/raw/master/servlet/block_list.txt"
					))));
			for (String thisLine : strings)
				list.add(thisLine);
		} catch (Exception e) {
			LoggerFactory.getLogger(DangerousWebsiteList.class).error("Exception:", e);
		}
	}

	public boolean addDangerousWebsite(String website) {
		return list.add(website);
	}

	public boolean isDanger(String website) {
		return list.contains(website);
	}
}

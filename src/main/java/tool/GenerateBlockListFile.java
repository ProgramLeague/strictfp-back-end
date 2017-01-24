package tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;

import static tool.Constant.PATH_TO_BLOCK_LIST;

/**
 * Created by Eldath on 2017/1/24 0024.
 *
 * @author Eldath
 */
public class GenerateBlockListFile {
	private static HashSet<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		String thisLine;
		try (BufferedReader bf = Files.newBufferedReader(Paths.get(PATH_TO_BLOCK_LIST))) {
			while ((thisLine = bf.readLine()) != null)
				addHost(thisLine);
		}
		try (BufferedReader bf1 = Files.newBufferedReader(Paths.get("F:\\Code\\nblist.txt"))) {
			while ((thisLine = bf1.readLine()) != null)
				addHost(thisLine);
		}
		BufferedWriter bw = Files.newBufferedWriter(Paths.get("F:\\blocklist.txt"), StandardCharsets.UTF_8);
		for (String thisElement : set) {
			bw.write(thisElement);
			bw.newLine();
		}
	}

	private static void addHost(String input) throws MalformedURLException {
		set.add(new URL("http://" + input).getHost());
	}
}

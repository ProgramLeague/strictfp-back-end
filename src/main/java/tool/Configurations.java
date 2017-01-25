package tool;

import db.obj.Pair;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Properties;

import static tool.Tools.forceRun;

/**
 * Translated from Frice-Engine
 * Created by ice1000 on 2016/8/20.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public class Configurations {
	@NotNull
	private File file;
	@NotNull
	private final Properties properties;
	@Nullable
	private static Configurations sharedInstance;

	@NotNull
	public static Configurations getSharedInstance() {
		if (sharedInstance == null) try {
			sharedInstance = new Configurations();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return sharedInstance;
	}

	public static void setSharedInstance(@NotNull Configurations sharedInstance) {
		Configurations.sharedInstance = sharedInstance;
	}

	@SuppressWarnings("ResultOfMethodCallIgnored")
	private Configurations() throws IOException {
		this(new URL("https://coding.net/u/ice1000/p/Images/git/raw/master/servlet/config.properties"),
				new File("./res/config.properties"));
	}

	public Configurations(@NotNull File file) {
		this.file = file;
		properties = new Properties();
		if (!file.exists()) forceRun(file::createNewFile);
		forceRun(() -> properties.load(new FileInputStream(file)));
	}

	public Configurations(@NotNull URL url, @NotNull File localFile) throws IOException {
		Files.deleteIfExists(localFile.toPath());
		properties = new Properties();
		file = localFile;
		forceRun(() -> properties.load(url.openStream()));
	}

	public Configurations(@NotNull URL url, @NotNull String localFile) throws IOException {
		this(url, new File(localFile));
	}

	public void insert(@NotNull Pair pair) {
		insert(pair.getKey(), pair.getValue());
	}

	public void insert(@NotNull @NonNls String key, @NotNull @NonNls String value) {
		properties.setProperty(key, value);
		save();
	}

	private void save() {
		forceRun(() -> properties.store(
				new FileOutputStream(file),
				"Automatically generated by ice1000 Frice Engine")
		);
	}

	@Nullable
	@NonNls
	public String query(@NotNull @NonNls String key) {
		return properties.getProperty(key);
	}

	public void clear() {
		properties.clear();
		save();
	}
}

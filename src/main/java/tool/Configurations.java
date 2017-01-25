package tool;

import db.obj.Pair;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
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
	@Nullable
	private File file;
	@NotNull
	private final Properties properties;
	@Nullable
	private static Configurations sharedInstance;

	@NotNull
	public static Configurations getSharedInstance() {
		if (sharedInstance == null) sharedInstance = new Configurations();
		return sharedInstance;
	}

	public static void setSharedInstance(@NotNull Configurations sharedInstance) {
		Configurations.sharedInstance = sharedInstance;
	}

	@SuppressWarnings("ResultOfMethodCallIgnored")
	public Configurations() {
		this(new File("./res/config.properties"));
	}

	public Configurations(@NotNull File file) {
		this.file = file;
		properties = new Properties();
		if (!file.exists()) forceRun(file::createNewFile);
		forceRun(() -> properties.load(new FileInputStream(file)));
	}

	public Configurations(@NotNull URL url, @NotNull File localFile) {
		properties = new Properties();
		file = localFile;
		forceRun(() -> properties.load(url.openStream()));
	}

	public Configurations(@NotNull URL url, @NotNull String localFile) {
		this(url, new File(localFile));
	}

	public Configurations(@NotNull @NonNls String file) {
		this(new File(file));
	}

	public void insert(@NotNull Pair pair) {
		insert(pair.getKey(), pair.getValue());
	}

	public void insert(@NotNull @NonNls String key, @NotNull @NonNls String value) {
		properties.setProperty(key, value);
		save();
	}

	private void save() {
		if (file != null) forceRun(() -> properties.store(
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

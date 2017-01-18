package db.obj;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import java.net.URL;

/**
 * @author Eldath
 */
public class Writer {

	@NotNull
	@Nls
	private String name, motto;
	private URL avatarURL;
	private Gender gender;

	public Writer(
			@NotNull @Nls String name,
			@NotNull @Nls String motto,
			@NotNull URL avatarURL,
			@NotNull Gender gender) {
		this.name = name;
		this.motto = motto;
		this.avatarURL = avatarURL;
		this.gender = gender;
	}

	@NotNull
	@Contract(pure = true)
	public String getName() {
		return name;
	}

	@NotNull
	@Contract(pure = true)
	public String getMotto() {
		return motto;
	}

	public URL getAvatarURL() {
		return avatarURL;
	}

	public Gender getGender() {
		return gender;
	}

	/**
	 * Created by Eldath on 2017/1/18 0018.
	 *
	 * @author Eldath
	 */
	enum Gender {
		MALE, FEMALE, SECRECY
	}
}

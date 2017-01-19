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
	private int Id;
	private URL avatarURL;
	private Gender gender;

	public Writer(
			@NotNull int Id,
			@NotNull @Nls String name,
			@NotNull @Nls String motto,
			@NotNull URL avatarURL,
			@NotNull Gender gender) {
		this.Id = Id;
		this.name = name;
		this.motto = motto;
		this.avatarURL = avatarURL;
		this.gender = gender;
	}

	@NotNull
	public int getId() {
		return Id;
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

	@NotNull
	@Contract(pure = true)
	public URL getAvatarURL() {
		return avatarURL;
	}

	@NotNull
	@Contract(pure = true)
	public Gender getGender() {
		return gender;
	}
}

class Gender {
	private int Int;
	private String Eng;

	public Gender(String eng, int gender) {
		Eng=eng;
		Int = gender;
	}

	public int getInt() {
		return Int;
	}

	public String getEng() {
		return Eng;
	}
}

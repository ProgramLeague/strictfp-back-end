package db.obj;

import java.net.URL;

/**
 * Created by Eldath on 2017/1/18 0018.
 *
 * @author Eldath
 */

enum Gender {
	MALE, FEMALE, SECRECY
}

public class Writer {
	private String name, motto;
	private URL avatarURL;
	private Gender gender;

	public Writer(String name, String motto, URL avatarURL, Gender gender) {
		this.name = name;
		this.motto = motto;
		this.avatarURL = avatarURL;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public String getMotto() {
		return motto;
	}

	public URL getAvatarURL() {
		return avatarURL;
	}

	public Gender getGender() {
		return gender;
	}
}

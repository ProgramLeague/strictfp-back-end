package db.obj;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.net.URL;

/**
 * @author Eldath
 */
//TODO: such name may cause misunderstandings. 'Author' may be better. - Akari
public class Writer {

	@NotNull
	@NonNls
	private String name;
	@NotNull
	@NonNls
	private String motto;
	@NotNull
	private URL avatarURL;
	@NotNull
	private Gender gender;
	private int Id;
	@NotNull
	private WriterType writerType;

	public Writer(
			int Id,
			@NotNull WriterType writerType,
			@NotNull @Nls String name,
			@NotNull @Nls String motto,
			@NotNull URL avatarURL,
			@NotNull Gender gender) {
		this.Id = Id;
		this.writerType = writerType;
		this.name = name;
		this.motto = motto;
		this.avatarURL = avatarURL;
		this.gender = gender;
	}

	@Contract(pure = true)
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
	public URL getAvatar() {
		return avatarURL;
	}

	@NotNull
	public WriterType getWriterType() {
		return writerType;
	}

	@NotNull
	@Contract(pure = true)
	public int getGender() {
		return gender.getInt();
	}
}


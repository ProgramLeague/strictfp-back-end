package db.obj;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.net.URL;

/**
 * should we change the MySQL column name too? - ice1000
 *
 * @author Eldath
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Author implements
		SqlObject {

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
	@NotNull
	private WriterType writerType;
	private int Id;

	public Author(
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

	@Contract(pure = true)
	public int getGender() {
		return gender.getNumber();
	}

	@NotNull
	@Override
	public String toSqlString() {
		return getId() + "," +
				getWriterType().toString() + "," +
				getName() + "," +
				"" + "," + // FIXME  那个pass字段咋回事 我不知道该往里面塞啥东西 --ice1000
				getMotto() + "," +
				getAvatar().toString() + "," +
				getGender();
	}
}


package dto;

public class UsersDTO {
	private String name;
	private String id;
	private String pw;
	private String tel;
	private String gender;
	private String birth;
	private String email;

	public UsersDTO() {

	}

	public UsersDTO(String name, String id, String pw, String tel, String gender, String birth, String email) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.tel = tel;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
	}

	@Override
	public String toString() {
		String str = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s", name, id, pw, tel, gender, birth, email);
		return str;
	}

	// getter & setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

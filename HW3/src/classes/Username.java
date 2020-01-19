package classes;

public class Username {
	private String userName ;
	private String password;
	private String rank;
	
	public Username(String username , String password , String rank) {
		this.userName = username;
		this.password = password;
		this.rank = rank;
	}

	public Username(String username , String password) {
		this.userName = username;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getRank() {
		return rank;
	}

}

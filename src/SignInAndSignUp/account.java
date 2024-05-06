package SignInAndSignUp;

public class account {
	private String user;
	private String password;
	private long maxPoint;
	public account(String user, String password, long maxPoint) {
		super();
		this.user = user;
		this.password = password;
		this.maxPoint = maxPoint;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMaxPoint() {
		return maxPoint;
	}
	public void setMaxPoint(long maxPoint) {
		this.maxPoint = maxPoint;
	}
}

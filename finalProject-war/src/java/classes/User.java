package classes;




public abstract class User {

	private int id;
        private static int count=0;
	private String name;
	private String password;
	private int permission;
		
	public User() {
	
	}
	public User(String name, String password, int permission) {
		this.id = count++;
		this.name = name;
		this.password = password;
		this.permission = permission;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	
		
}

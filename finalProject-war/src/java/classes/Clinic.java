package classes;




import java.util.LinkedList;
import java.util.List;

public class Clinic {
	private static Clinic clinic;
	private List<User> users = new LinkedList<User>();

	private Clinic() {
                Doctor d = new Doctor("a","a",2);
                Doctor d2 = new Doctor("b","b",2);
                Patient p = new Patient("c","c",1);
                d.addPatient(p);
		users.add(d);
                users.add(d2);
                users.add(p);
	}

	public List<User> getUsers() {
		return users;
	}
	
	public static Clinic getInstance() {
		if(clinic == null)
			clinic = new Clinic();
		return clinic;
	}
	
	public User addUser(String name, String password, int permission) {
		User user = UserFactory.createUser(name, password, permission);
		users.add(user);
		return user;
	}
	
	public User getUser(String name, String password){
		for (User user : users) {
			if(user.getName().equals(name)&&user.getPassword().equals(password))
				return user;
		}
		return null;
	}
			
}

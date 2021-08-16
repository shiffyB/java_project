package classes;

public class UserFactory {

    public static User createUser(String name, String password, int permission) {
        User user;
        if (permission == 1) {
            user = new Patient(name, password, permission);
        } else {
            user = new Doctor(name, password, permission);
        }
        return user;
    }
}

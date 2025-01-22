public class User extends Person {
    private String name;
    private String password;

    public User(String name, String password) {
       // super(name, employContact, name, address);
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                "} ";
    }
}
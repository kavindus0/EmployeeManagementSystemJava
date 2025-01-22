public class EmergencyContact extends Person{
    public EmergencyContact(String name, String contactNo, String email, String address) {
        super(name, contactNo, email, address);
    }

    public EmergencyContact(String name, int employContact, String email, Object address) {
        super(name, employContact, email, address);
    }

    @Override
    public String toString() {
        return "EmergencyContact{} " + super.toString();
    }
}

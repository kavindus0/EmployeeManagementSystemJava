public abstract class Person {
    private  String name;
    private  String contactNo;
    private  String email;
    private  String address;

    public Person(String name,String contactNo, String email, String address) {
        this.address = address;
        this.contactNo = contactNo;
        this.email = email;
        this.name = name;
    }

    protected Person(String s, int employContact, String name, Object address) {
        this.name = name;
    }

    public Person() {

    }

    void getInfo() throws Exception {
        System.out.println("Name: " + name);
    }


    protected Object getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

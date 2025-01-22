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

    protected Person(String name) {
        this.name = name;
    }

    void getInfo() throws Exception {
        System.out.println("Name: " + name);
    }




}

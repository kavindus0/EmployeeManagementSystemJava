import java.io.IOException;
import java.util.Scanner;

class EmployDetail extends Person {
    private String name;
    private String email;
    private String position;
    private String address;
    private String employ_id;
    private double employ_salary;
    private int employ_contact;
    private String emergencyContact_name;
    private String emergencyContact_contact;
    private String emergencyContact_address;
    private String emergencyContact_email;

    public EmployDetail(String name, String contactNo, String email, String address, String emergencyContact_address, String emergencyContact_contact, String emergencyContact_email, String emergencyContact_name) {
        super(name, contactNo, email, address);
        this.emergencyContact_address = emergencyContact_address;
        this.emergencyContact_contact = emergencyContact_contact;
        this.emergencyContact_email = emergencyContact_email;
        this.emergencyContact_name = emergencyContact_name;
    }

    public EmployDetail() {
        super();
    }

    @Override
    public String toString() {
        return "EmployDetail{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", employ_id='" + employ_id + '\'' +
                ", employ_salary=" + employ_salary +
                ", employ_contact=" + employ_contact +
                ", emergencyContact_name='" + emergencyContact_name + '\'' +
                ", emergencyContact_contact='" + emergencyContact_contact + '\'' +
                ", emergencyContact_address='" + emergencyContact_address + '\'' +
                ", emergencyContact_email='" + emergencyContact_email + '\'' +
                "} " + super.toString();
    }

    public double getSalary() {
        return employ_salary;
    }

    public String getEmail() {
        return email;
    }

    public int getEmploy_contact() {
        return employ_contact;
    }

    public String getEmploy_id() {
        return employ_id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getEmploy_salary() {
        return employ_salary;
    }

    public void setEmploy_salary(double employ_salary) {
        this.employ_salary = employ_salary;
    }

    public String getEmergencyContact_name() {
        return emergencyContact_name;
    }

    public String getEmergencyContact_contact() {
        return emergencyContact_contact;
    }

    public String getEmergencyContact_address() {
        return emergencyContact_address;
    }

    public String getEmergencyContact_email() {
        return emergencyContact_email;
    }

    @Override
    public void getInfo() throws IOException {
        Scanner sc = new Scanner(System.in);

        // Get Employee Name
        System.out.print("Enter Employee's Name --------: ");
        name = sc.nextLine().trim();
        while (name.isEmpty()) {
            System.out.print("Name cannot be empty. Enter Employee's Name --------: ");
            name = sc.nextLine().trim();
        }

        // Get Employee ID
        System.out.print("Enter " + name + "'s ID ----------: ");
        employ_id = sc.nextLine().trim();
        while (employ_id.isEmpty()) {
            System.out.print("ID cannot be empty. Enter " + name + "'s ID ----------: ");
            employ_id = sc.nextLine().trim();
        }

        // Get Email
        System.out.print("Enter " + name + "'s Email ID ----: ");
        email = sc.nextLine().trim();
        while (email.isEmpty() || !email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            System.out.print("Invalid email format. Enter " + name + "'s Email ID ----: ");
            email = sc.nextLine().trim();
        }

        // Get Position
        System.out.print("Enter " + name + "'s Position ----: ");
        position = sc.nextLine().trim();
        while (position.isEmpty()) {
            System.out.print("Position cannot be empty. Enter " + name + "'s Position ----: ");
            position = sc.nextLine().trim();
        }

        // Get Contact Info
        System.out.print("Enter " + name + "'s Contact Info : ");
        while (true) {
            try {
                employ_contact = Integer.parseInt(sc.nextLine().trim());
                if (String.valueOf(employ_contact).length() != 9) {
                    throw new IllegalArgumentException("Contact number format is 712345678.");
                }
                break;
            } catch (Exception e) {
                System.out.print("Invalid contact number. Enter a valid Contact Info, Format is 712345678 : ");
            }
        }

        // Get Salary
        System.out.print("Enter " + name + "'s Salary ------: ");
        while (true) {
            try {
                setEmploy_salary(Double.parseDouble(sc.nextLine().trim()));
                if (getEmploy_salary() <= 0) {
                    throw new IllegalArgumentException("Salary must be greater than zero.");
                }
                break;
            } catch (Exception e) {
                System.out.print("Invalid salary. Enter a valid Salary ------: ");
            }
        }


        // Get Emergency Contact Name
        System.out.print("Enter " + name + "'s Emergency Contact's Name -: ");
        emergencyContact_name = sc.nextLine().trim();
        while (emergencyContact_name.isEmpty()) {
            System.out.print("Emergency Contact's name cannot be empty. Enter " + name + "'s Emergency Contact's Name -: ");
            emergencyContact_name = sc.nextLine().trim();
        }

        // Get Emergency Contact Number
        System.out.print("Enter " + name + "'s Emergency Contact Number -: ");
        emergencyContact_contact = sc.nextLine().trim();
        while (emergencyContact_contact.isEmpty() || !emergencyContact_contact.matches("\\d{9}")) {
            System.out.print("Emergency Contact number must be 9 digits. Enter " + name + "'s Emergency Contact Number -: ");
            emergencyContact_contact = sc.nextLine().trim();
        }

        // Get Emergency Contact Address
        System.out.print("Enter " + name + "'s Emergency Contact Address -: ");
        emergencyContact_address = sc.nextLine().trim();
        while (emergencyContact_address.isEmpty()) {
            System.out.print("Emergency Contact address cannot be empty. Enter " + name + "'s Emergency Contact Address -: ");
            emergencyContact_address = sc.nextLine().trim();
        }

        // Get Emergency Contact Email
        System.out.print("Enter " + name + "'s Emergency Contact Email -: ");
        emergencyContact_email = sc.nextLine().trim();
        while (emergencyContact_email.isEmpty() || !emergencyContact_email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            System.out.print("Invalid email format. Enter " + name + "'s Emergency Contact Email -: ");
            emergencyContact_email = sc.nextLine().trim();
        }


        // Generate Salary Summary
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        SalaryCalculator.generateSalarySummary(employ_id, salaryCalculator, this.employ_salary);
    }
}
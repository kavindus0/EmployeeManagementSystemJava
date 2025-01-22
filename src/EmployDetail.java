import java.io.IOException;
import java.util.Scanner;
class EmployDetail extends Person{
   private String name;
   private String father_name;
   private String email;
   private String position;
   private String employ_id;
    private double employ_salary;
   private int employ_contact;

    public EmployDetail(String employ_id, double employ_salary,String name) {
        super(name);
        this.employ_id = employ_id;
        this.employ_salary = employ_salary;
    }

    @Override
    public String toString() {
        return "EmployDetail{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", father_name='" + father_name + '\'' +
                ", position='" + position + '\'' +
                ", employ_id='" + employ_id + '\'' +
                ", employ_salary=" + employ_salary +
                ", employ_contact=" + employ_contact +
                "} ";
    }

    public EmployDetail(String email, int employ_contact, String employ_id, double employ_salary, String father_name, String name, String position) {
        super(name);
        this.email = email;
        this.employ_contact = employ_contact;
        this.employ_id = employ_id;
        this.employ_salary = employ_salary;
        this.father_name = father_name;
        this.name = name;
        this.position = position;
    }

    public EmployDetail() {
        super("");
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

    public String getFather_name() {
        return father_name;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    double getEmploy_salary(){
        return employ_salary;
    }
    void setEmploy_salary(double employ_salary){
        this.employ_salary = employ_salary;
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

        // Get Father Name
        System.out.print("Enter " + name + "'s Father Name -: ");
        father_name = sc.nextLine().trim();
        while (father_name.isEmpty()) {
            System.out.print("Father's name cannot be empty. Enter " + name + "'s Father Name -: ");
            father_name = sc.nextLine().trim();
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
        while (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
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


        SalaryCalculator salaryCalculator = new SalaryCalculator();
        SalaryCalculator.generateSalarySummary(employ_id,salaryCalculator, this.employ_salary);



    }
}
import java.util.Scanner;
class EmployDetail {
    String name, father_name, email, position, employ_id;
    double employ_salary;
    int employ_contact;

    public void getInfo() {
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
                if (String.valueOf(employ_contact).length() != 10) {
                    throw new IllegalArgumentException("Contact number must be 10 digits.");
                }
                break;
            } catch (Exception e) {
                System.out.print("Invalid contact number. Enter a valid Contact Info : ");
            }
        }

        // Get Salary
        System.out.print("Enter " + name + "'s Salary ------: ");
        while (true) {
            try {
                employ_salary = Double.parseDouble(sc.nextLine().trim());
                if (employ_salary <= 0) {
                    throw new IllegalArgumentException("Salary must be greater than zero.");
                }
                break;
            } catch (Exception e) {
                System.out.print("Invalid salary. Enter a valid Salary ------: ");
            }
        }
    }
}